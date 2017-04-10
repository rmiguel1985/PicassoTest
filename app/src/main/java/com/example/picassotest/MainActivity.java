package com.example.picassotest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView logo;
    private Button btnResize;
    private Button btnCrop;
    private Button btnRotation;
    private Button btnTransform;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = (ImageView) findViewById(R.id.resize_img);

        btnResize = (Button) findViewById (R.id.maint_btn_resize);
        btnCrop = (Button) findViewById (R.id.maint_btn_crop);
        btnRotation = (Button) findViewById (R.id.main_btn_rotation);
        btnTransform = (Button) findViewById (R.id.maint_btn_transform);

        btnResize.setOnClickListener(this);
        btnCrop.setOnClickListener(this);
        btnRotation.setOnClickListener(this);
        btnTransform.setOnClickListener(this);

        String remoteUrl = "http://www.guitarthai.com/picpost/gtpicpost/Q367224.jpg";

        // Set Loggin and indicators
        // To see  logging filter Logcat by Picasso
        Picasso.with(this).setLoggingEnabled(true);
        Picasso.with(this).setIndicatorsEnabled(true);

        Picasso
                .with(this)
                .load(remoteUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(logo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.maint_btn_resize:
                Intent intentResize = new Intent(this, ResizeActivity.class);
                startActivity(intentResize);
                break;
            case R.id.maint_btn_crop:
                Intent intentCrop = new Intent(this, CropActivity.class);
                startActivity(intentCrop);
                break;
            case R.id.main_btn_rotation:
                Intent intentRotation = new Intent(this, RotationActivity.class);
                startActivity(intentRotation);
                break;
            case R.id.maint_btn_transform:
                Intent intentTransform = new Intent(this, TransformActivity.class);
                startActivity(intentTransform);
                break;
        }
    }
}
