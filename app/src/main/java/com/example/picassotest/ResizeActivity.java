package com.example.picassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrador on 07/06/2016.
 */
public class ResizeActivity extends AppCompatActivity {

    private ImageView resize;
    private ImageView fit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resize);

        resize = (ImageView) findViewById(R.id.resize_img);
        fit = (ImageView) findViewById(R.id.resize_img_fit);


        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .resize(100, 100)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(resize);

        Picasso
                .with(this)
                .load(remoteUrl)
                .fit()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(fit);
    }

}
