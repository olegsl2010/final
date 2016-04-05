package ua.olegsl.fruits.data;

import android.content.Context;

import java.util.ArrayList;

import ua.olegsl.fruits.R;
import ua.olegsl.fruits.instance.Fruit;

/**
 * Created by olegs on 04.04.2016.
 */
public class InsertFruit {

    private static InsertFruit insertFruit;
    private Context context;

    public static InsertFruit get(Context context){
        if(insertFruit==null){
            insertFruit= new InsertFruit(context);
        }
        return insertFruit;
    }
    private InsertFruit(Context context) {
        this.context = context;
    }

    public ArrayList<Fruit> InsertFruit() {
        ArrayList<Fruit> fruitArrayList = new ArrayList<>();
        Fruit fruit = new Fruit();
        fruit.setmNameFruit(context.getResources().getString(R.string.apricot));
        fruit.setmDescriptionFruit(context.getResources().getString(R.string.apricot_descr));
        fruit.setmNameFungicide(context.getResources().getString(R.string.fungicide));
        fruit.setmNamePesticide(context.getResources().getString(R.string.pesticide));
        String uri = "@drawable/apricot";
        int imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        fruit.setmImageFruit(imageResource);
        fruit.setmCountFungicide(1);
        fruit.setmCountPesticide(1);
        fruitArrayList.add(fruit);
        fruit = new Fruit();
        fruit.setmNameFruit(context.getResources().getString(R.string.persica));
        fruit.setmDescriptionFruit(context.getResources().getString(R.string.persics_descr));
        fruit.setmNameFungicide(context.getResources().getString(R.string.fungicide));
        fruit.setmNamePesticide(context.getResources().getString(R.string.pesticide));
        uri = "@drawable/persica";
        imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        fruit.setmImageFruit(imageResource);
        fruit.setmCountFungicide(2);
        fruit.setmCountPesticide(2);
        fruitArrayList.add(fruit);
        fruit = new Fruit();
        fruit.setmNameFruit(context.getResources().getString(R.string.prunus));
        fruit.setmDescriptionFruit(context.getResources().getString(R.string.prunus_descr));
        fruit.setmNameFungicide(context.getResources().getString(R.string.fungicide));
        fruit.setmNamePesticide(context.getResources().getString(R.string.pesticide));
        uri = "@drawable/prunus";
        imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        fruit.setmImageFruit(imageResource);
        fruit.setmCountFungicide(3);
        fruit.setmCountPesticide(3);
        fruitArrayList.add(fruit);
        fruit = new Fruit();
        fruit.setmNameFruit(context.getResources().getString(R.string.pyrus));
        fruit.setmDescriptionFruit(context.getResources().getString(R.string.pyrus_descr));
        fruit.setmNameFungicide(context.getResources().getString(R.string.fungicide));
        fruit.setmNamePesticide(context.getResources().getString(R.string.pesticide));
        uri = "@drawable/pyrus";
        imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        fruit.setmImageFruit(imageResource);
        fruit.setmCountFungicide(4);
        fruit.setmCountPesticide(4);
        fruitArrayList.add(fruit);
        fruit = new Fruit();
        fruit.setmNameFruit(context.getResources().getString(R.string.apple));
        fruit.setmDescriptionFruit(context.getResources().getString(R.string.apple_descr));
        fruit.setmNameFungicide(context.getResources().getString(R.string.fungicide));
        fruit.setmNamePesticide(context.getResources().getString(R.string.pesticide));
        uri = "@drawable/apple";
        imageResource = context.getResources().getIdentifier(uri, null, context.getPackageName());
        fruit.setmImageFruit(imageResource);
        fruit.setmCountFungicide(5);
        fruit.setmCountPesticide(5);
        fruitArrayList.add(fruit);
        return fruitArrayList;
    }

}
