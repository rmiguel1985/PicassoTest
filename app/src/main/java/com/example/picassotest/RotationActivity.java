package com.example.picassotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrador on 07/06/2016.
 */
public class RotationActivity extends AppCompatActivity {

    private ImageView rotation;
    private ImageView pivotRotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);

        rotation = (ImageView) findViewById(R.id.resize_img);
        pivotRotation = (ImageView) findViewById(R.id.resize_img_fit);


        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .rotate(180f)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(rotation);

        Picasso
                .with(this)
                .load(remoteUrl)
                .rotate(45f, 200f, 100f)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(pivotRotation);
    }
}
