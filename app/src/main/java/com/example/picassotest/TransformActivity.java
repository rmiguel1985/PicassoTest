package com.example.picassotest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.ColorFilterTransformation;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

/**
 * Created by Administrador on 07/06/2016.
 */
public class TransformActivity extends AppCompatActivity {

    private ImageView transform;
    private ImageView multipleTransform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transform);

        transform = (ImageView) findViewById(R.id.resize_img);
        multipleTransform = (ImageView) findViewById(R.id.resize_img_fit);


        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .transform(new CropCircleTransformation())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(transform);

        int color = Color.parseColor("#3300ff80");
        Picasso
                .with(this)
                .load(remoteUrl)
                .transform(new ColorFilterTransformation(color))
                .transform(new CropCircleTransformation())
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(multipleTransform);

    }
}
