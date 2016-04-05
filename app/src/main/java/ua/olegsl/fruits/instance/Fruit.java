package ua.olegsl.fruits.instance;

import java.io.Serializable;

/**
 * Created by olegs on 04.04.2016.
 */
public class Fruit implements Serializable {

    private String mNameFruit;
    private String mDescriptionFruit;
    private String mNameFungicide;
    private int mCountFungicide;
    private String mNamePesticide;
    private int mCountPesticide;
    private int mImageFruit;

    public int getmImageFruit() {
        return mImageFruit;
    }

    public void setmImageFruit(int mImageFruit) {
        this.mImageFruit = mImageFruit;
    }

    public String getmNameFruit() {
        return mNameFruit;
    }

    public void setmNameFruit(String mNameFruit) {
        this.mNameFruit = mNameFruit;
    }

    public String getmDescriptionFruit() {
        return mDescriptionFruit;
    }

    public void setmDescriptionFruit(String mDescriptionFruit) {
        this.mDescriptionFruit = mDescriptionFruit;
    }

    public String getmNameFungicide() {
        return mNameFungicide;
    }

    public void setmNameFungicide(String mNameFungicide) {
        this.mNameFungicide = mNameFungicide;
    }

    public int getmCountFungicide() {
        return mCountFungicide;
    }

    public void setmCountFungicide(int mCountFungicide) {
        this.mCountFungicide = mCountFungicide;
    }

    public String getmNamePesticide() {
        return mNamePesticide;
    }

    public void setmNamePesticide(String mNamePesticide) {
        this.mNamePesticide = mNamePesticide;
    }

    public int getmCountPesticide() {
        return mCountPesticide;
    }

    public void setmCountPesticide(int mCountPesticide) {
        this.mCountPesticide = mCountPesticide;
    }
}
