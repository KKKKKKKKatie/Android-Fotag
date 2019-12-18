package com.example.j253zhao.fotagj253zhao;
import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;

public class ImageCollection {
    ArrayList<ImageModel> im;
    ArrayList<ImageModel> backup;
    int currate;
    Context ct;

    public ImageCollection(Context ct) {
        this.im = new ArrayList<ImageModel>();
        this.backup = new ArrayList<ImageModel>();
        this.currate = 0;
        this.ct = ct;
    }
    public void loadim(Resources r) {
        ImageModel image0 = new ImageModel(this, R.drawable.a0, ct, r);
        im.add(image0);
        ImageModel image1 = new ImageModel(this, R.drawable.a1, ct, r);
        im.add(image1);
        ImageModel image2 = new ImageModel(this, R.drawable.a2, ct, r);
        im.add(image2);
        ImageModel image3 = new ImageModel(this, R.drawable.a3, ct, r);
        im.add(image3);
        ImageModel image4 = new ImageModel(this, R.drawable.a4, ct, r);
        im.add(image4);
        ImageModel image5 = new ImageModel(this, R.drawable.a5, ct, r);
        im.add(image5);
        ImageModel image6 = new ImageModel(this, R.drawable.a6, ct, r);
        im.add(image6);
        ImageModel image7 = new ImageModel(this, R.drawable.a7, ct, r);
        im.add(image7);
        ImageModel image8 = new ImageModel(this, R.drawable.a8, ct, r);
        im.add(image8);
        ImageModel image9 = new ImageModel(this, R.drawable.a9, ct, r);
        im.add(image9);
        getim();
    }
    public void getim() {
        backup.clear();
        for (int i = 0; i < im.size(); i++) {
            if (im.get(i).rate >= currate) {
                backup.add(im.get(i));
            }
        }
    }
}
