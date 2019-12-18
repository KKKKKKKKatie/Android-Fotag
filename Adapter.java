package com.example.j253zhao.fotagj253zhao;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;

import java.io.ByteArrayOutputStream;

public class Adapter extends ArrayAdapter<ImageModel> {
    ImageCollection ic;
    Context ct;
    ImageButton clearrate;
    RatingBar rb;
    ImageView picture;
    Activity a;
    //boolean isfull;
    public Adapter(Activity a, ImageCollection ic) {
        super(a, R.layout.view, ic.backup);
        this.a = a;
        this.ic = ic;
        //this.ct = ct;
    }
    public View getView(final int location, View convertView, ViewGroup vg) {
        ic.getim();
        //View v = LayoutInflater.from(ct).inflate(R.layout.view, vg, false);
        LayoutInflater inflater = a.getLayoutInflater();
        View v = inflater.inflate(R.layout.view, null, true);

        rb = (RatingBar) v.findViewById(R.id.imagerate);
        rb.setNumStars(5);
        rb.setStepSize((float) 1.0);
        rb.setMax(5);
        ic.getim();
        rb.setRating(ic.backup.get(location).rate);
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ic.backup.get(location).setrate((int) v);
                ic.getim();
            }
        });
        clearrate = (ImageButton) v.findViewById(R.id.clear);
        clearrate.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                rb.setRating(0);
                ic.backup.get(location).setrate(0);
                ic.getim();
            }
        });
        picture = (ImageView) v.findViewById(R.id.image);
        final Bitmap i = ic.backup.get(location).bm;
        picture.setImageBitmap(i);
        picture.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bmp = BitmapFactory.decodeResource(ic.backup.get(location).ct.getResources(), ic.backup.get(location).id);
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();
                Intent intent = new Intent(a,large.class);
                intent.putExtra("picture", byteArray);
                a.startActivity(intent);
            }
        });
        return v;
    };
}

