package ua.olegsl.fruits.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.olegsl.fruits.MainActivity;
import ua.olegsl.fruits.R;

/**
 * Created by olegs on 05.04.2016.
 */
public class AboutFragment extends Fragment {


    public static AboutFragment newInstance (){
        AboutFragment mSettingsFragment = new AboutFragment();

        return mSettingsFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_about, container,false);
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.GONE);

        return rootview;
    }

    @Override
    public void onPause() {
        super.onPause();
        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setVisibility(View.VISIBLE);
    }
}
