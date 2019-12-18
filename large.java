package com.example.j253zhao.fotagj253zhao;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class large extends Activity{
    @Override
    protected void onCreate(Bundle sacedInstanceState) {
        super.onCreate(sacedInstanceState);
        setContentView(R.layout.large);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (height * .6));
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.fullimage);
        image.setImageBitmap(bmp);

    }
}
