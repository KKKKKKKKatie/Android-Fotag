package com.example.j253zhao.fotagj253zhao;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageCollection ic;
    GridView gv;
    Adapter ad;
    RatingBar star;
    ImageButton load;
    ImageButton clearall;
    ImageButton clearstar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(getResources().getDisplayMetrics().widthPixels>getResources().getDisplayMetrics().
                heightPixels)
        {
            Toast.makeText(this,"Screen switched to Landscape mode",Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this,"Screen switched to Portrait mode",Toast.LENGTH_SHORT).show();
        }

        ic = new ImageCollection(this);
        ad = new Adapter(this, ic);
        gv = (GridView) findViewById(R.id.grid);
        star = (RatingBar) findViewById(R.id.rate);
        star.setNumStars(5);
        star.setStepSize((float) 1.0);
        star.setMax(5);

        star.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                ic.currate = (int) v;
                ic.getim();
                gv.setAdapter(ad);
            }
        });
        load = (ImageButton) findViewById(R.id.load);
        load.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resources r = getResources();
                if (ic.im.size() == 0) {
                    ic.loadim(r);
                    gv.setAdapter(ad);
                }
            }
        });
        clearall = (ImageButton) findViewById(R.id.clearall);
        clearall.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                ic.im.clear();
                ic.backup.clear();
                gv.setAdapter(ad);
                }
        });
        clearstar = (ImageButton) findViewById(R.id.clearstar);
        clearstar.setOnClickListener(new ImageButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                star.setRating(0);
                ic.getim();
                gv.setAdapter(ad);
            }
        });
    }
    @Override
    public void onConfigurationChanged(Configuration cf) {
        super.onConfigurationChanged(cf);
        if (cf.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gv.setNumColumns(2);

        } else if (cf.orientation == Configuration.ORIENTATION_PORTRAIT) {
            gv.setNumColumns(1);
        }
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
