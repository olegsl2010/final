package ua.olegsl.fruits.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.olegsl.fruits.MainActivity;
import ua.olegsl.fruits.R;

/**
 * Created by olegs on 05.04.2016.
 */
public class SettingsFragment extends Fragment {

    @Bind(R.id.rbEnglish)
    RadioButton rbEnglish;
    @Bind(R.id.rbRussian) RadioButton rbRussian;
    @Bind(R.id.rgLanguage) RadioGroup rgLanguage;
    @Bind(R.id.btnLanguageOk)Button btnLanguageOk;

    public interface OnListenerLanguage{
        void onListenerLanguage(String language);
    }

    public static SettingsFragment newInstance (){
        SettingsFragment mSettingsFragment = new SettingsFragment();

        return mSettingsFragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_settings, container,false);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        ButterKnife.bind(this,rootView);
        switch (Locale.getDefault().getLanguage()){
            case "en":
                rbEnglish.setChecked(true);
                break;
            case "ru":
                rbRussian.setChecked(true);
                break;
        }
        btnLanguageOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioButtonID = rgLanguage.getCheckedRadioButtonId();
                String currLanguage = Locale.getDefault().getLanguage();
                OnListenerLanguage onListenerLanguage = (OnListenerLanguage) getActivity();

                switch (radioButtonID) {
                    case R.id.rbEnglish:
                        if(!currLanguage.equals("en")){
                        onListenerLanguage.onListenerLanguage("en");
                        }
                        break;
                    case R.id.rbRussian:
                        if(!currLanguage.equals("ru")) {
                            onListenerLanguage.onListenerLanguage("ru");
                        }
                        break;
                }


        }
    });

    return rootView;
}
    @Override
    public void onPause() {
        super.onPause();
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
