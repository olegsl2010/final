package ua.olegsl.fruits;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ua.olegsl.fruits.models.Fruit;


public class BaseFruitsFragment extends Fragment {

    public static final String TREESES = "treeses";
    private static final String FRUIT = "name_fruit";
    private Fruit fruit;
    @Bind(R.id.twNameFruit)TextView twNameFruit;
    @Bind(R.id.twCountPesticide)TextView twCountPesticide;
    @Bind(R.id.twCountPesticideName)TextView twCountPesticideName;
    @Bind(R.id.twCountFungicide)TextView twCountFungicide;
    @Bind(R.id.twCountFungicideName)TextView twCountFungicideName;
    @Bind(R.id.etCountTreeses) EditText etCountTreeses;
    @Bind(R.id.twDescFruit)TextView twDescrFruit;
    @Bind(R.id.ivFruit)ImageView ivFruit;

    public static BaseFruitsFragment newInstance (Fruit fruit){
        BaseFruitsFragment baseFruitsFragment = new BaseFruitsFragment();
        Bundle args = new Bundle();
        args.putSerializable(FRUIT, fruit);
        baseFruitsFragment.setArguments(args);

        return baseFruitsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args!=null) {
            fruit = (Fruit) args.getSerializable(FRUIT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fruits, container, false);
        ButterKnife.bind(this, rootView);
        twNameFruit.setText(fruit.getmNameFruit());
        twDescrFruit.setText(fruit.getmDescriptionFruit());
        twCountPesticide.setText(String.valueOf(fruit.getmCountPesticide())+" g");
        twCountPesticideName.setText(fruit.getmNamePesticide());
        twCountFungicide.setText(String.valueOf(fruit.getmCountFungicide())+" g");
        twCountFungicideName.setText(fruit.getmNameFungicide());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ivFruit.setBackground(getResources().getDrawable(fruit.getmImageFruit()));
        }else ivFruit.setImageDrawable(getResources().getDrawable(fruit.getmImageFruit()));

        etCountTreeses.setText("1");
        textChangeListener();
        return rootView;
    }

    private void textChangeListener() {
        etCountTreeses.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count>0) {
                    int treeses = Integer.parseInt(s.toString());
                    displayResult(treeses);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void displayResult(int treeses) {
        if(treeses<=0){
            etCountTreeses.setText("1");
        }else {
            getArguments().putInt(TREESES,treeses);
            twCountPesticide.setText(String.valueOf((fruit.getmCountPesticide())*treeses)+" g");
            twCountFungicide.setText(String.valueOf((fruit.getmCountFungicide())*treeses)+" ml");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
