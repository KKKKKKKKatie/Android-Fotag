package com.example.j253zhao.fotagj253zhao;
import android.content.res.Resources;
import android.graphics.*;
import android.content.*;

public class ImageModel {
    int rate;
    int id;
    Context ct;
    ImageCollection ic;
    Bitmap bm;

    public ImageModel(ImageCollection ic, int id, Context ct, Resources r) {
        this.rate = 0;
        this.id = id;
        this.ct = ct;
        this.ic = ic;
        this.bm = BitmapFactory.decodeResource(r, id);
    }
    public void setrate(int rate) {
        this.rate = rate;
        ic.getim();
    }
}
