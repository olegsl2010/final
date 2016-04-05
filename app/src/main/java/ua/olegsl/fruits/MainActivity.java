package ua.olegsl.fruits;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import ua.olegsl.fruits.data.InsertFruit;
import ua.olegsl.fruits.models.Fruit;

/**
 * Created by olegs on 04.04.2016.
 */
public class MainActivity extends BaseActivity{

    @Bind(R.id.viewpager)
    ViewPager viewPager;
    @Bind(R.id.tabs)
    TabLayout tabLayout;
    private ArrayList<Fruit> fruitArrayList;


    @Override
    protected int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InsertFruit insertFruit = InsertFruit.get(this);
        fruitArrayList = insertFruit.InsertFruit();
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {


        Adapter adapter = new Adapter(getSupportFragmentManager());
        for(int i = 0; i<fruitArrayList.size(); i++){
            adapter.addFragment(
                    BaseFruitsFragment.newInstance(fruitArrayList.get(i)),
                    fruitArrayList.get(i).getmNameFruit());
        }
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void sendEmail() {
        int treeses = 1;
        String tag = "android:switcher:"+viewPager.getId()+":"+viewPager.getCurrentItem();
              if(getSupportFragmentManager().findFragmentByTag(tag)!=null){
                  Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
                  treeses = fragment.getArguments().getInt(BaseFruitsFragment.TREESES,1);
              }
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.titleMail) + fruitArrayList.get(viewPager.getCurrentItem()).getmNameFruit());
        String body = fruitArrayList.get(viewPager.getCurrentItem()).getmCountFungicide()*treeses+ " - "+
                fruitArrayList.get(viewPager.getCurrentItem()).getmNameFungicide()+"\n"
                + fruitArrayList.get(viewPager.getCurrentItem()).getmCountPesticide()*treeses+ " - "
                +fruitArrayList.get(viewPager.getCurrentItem()).getmNamePesticide();
        i.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.bodyMail)+body);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }
}
