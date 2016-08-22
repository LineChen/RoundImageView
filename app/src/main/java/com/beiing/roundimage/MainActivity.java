package com.beiing.roundimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    CircleImageView circleImageView;

    RoundImageView roundImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageView = (CircleImageView) findViewById(R.id.circle_image);
        roundImageView = (RoundImageView) findViewById(R.id.round_image);

        Glide.with(this).load(R.mipmap.head).into(circleImageView);
    }
}
