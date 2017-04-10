package com.example.picassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrador on 07/06/2016.
 */
public class CropActivity extends AppCompatActivity {

    private ImageView insideCrop;
    private ImageView centerCrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        insideCrop = (ImageView) findViewById(R.id.resize_img_fit);
        centerCrop = (ImageView) findViewById(R.id.resize_img);

        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .resize(200, 200)
                .centerInside()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(insideCrop);

        Picasso
                .with(this)
                .load(remoteUrl)
                .resize(100, 100) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(centerCrop);
    }
}
