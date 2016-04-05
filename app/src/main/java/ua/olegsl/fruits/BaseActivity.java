package ua.olegsl.fruits;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.olegsl.fruits.menu.AboutFragment;
import ua.olegsl.fruits.menu.SettingsFragment;

public abstract class BaseActivity extends AppCompatActivity implements SettingsFragment.OnListenerLanguage {

    public static String LANGUAGE = "langeage";
    @Bind(R.id.fab)public FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout flContent = (FrameLayout) findViewById(R.id.flContent);
        View.inflate(this, setLayoutRes(), flContent);
        ButterKnife.bind(this);

        if(fab!=null){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sendEmail();
            }
        });
        }
        setLocale(this.getSharedPreferences(LANGUAGE,Context.MODE_PRIVATE).getString(LANGUAGE,"en"));
        this.setTitle(getString(R.string.app_name));
    }

    @Override
    protected void onResume() {
        super.onResume();
        fab.setVisibility(View.VISIBLE);
    }

    @Override
    public void onListenerLanguage(String language) {
        SharedPreferences.Editor spe = this.getSharedPreferences(LANGUAGE,Context.MODE_PRIVATE).edit();
        switch (language) {
            case "en":

                spe.putString(LANGUAGE, "en");
                spe.apply();
                setSettingsLocale("en");
                break;
            case "ru":
                spe.putString(LANGUAGE, "ru");
                spe.apply();
                setSettingsLocale("ru");
                break;
        }
    }

    protected void sendEmail() {
    }

    protected abstract int setLayoutRes();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.action_settings:
                replaceFragment(SettingsFragment.newInstance(),true, "settings");
                return true;
            case R.id.action_about:
                replaceFragment(AboutFragment.newInstance(),true, "about");
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void replaceFragment(Fragment fragment, boolean stack, String str){
        FragmentTransaction fragmentTransaction = this
                .getSupportFragmentManager()
                .beginTransaction();
        if(getSupportFragmentManager().findFragmentByTag(str)==null) {
            fragmentTransaction
                    .replace(R.id.flContent, fragment, str);
            if (stack) fragmentTransaction.addToBackStack(fragment.getClass().getCanonicalName());
            fragmentTransaction.commit();
        }else {
            fragmentTransaction
                    .replace(R.id.flContent, getSupportFragmentManager().findFragmentByTag(str), str);
            fragmentTransaction.disallowAddToBackStack();
            fragmentTransaction.commit();
        }
    }



    private void setSettingsLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Locale.setDefault(myLocale);

        Intent restartIntent = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage(getBaseContext().getPackageName());
        PendingIntent intent = PendingIntent.getActivity(
                getBaseContext(), 0,
                restartIntent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager manager = (AlarmManager) getBaseContext().getSystemService(Context.ALARM_SERVICE);
        manager.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, intent);
        System.exit(2);

    }
    private void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Locale.setDefault(myLocale);
    }
}
