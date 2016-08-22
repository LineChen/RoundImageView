package com.beiing.roundimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import org.xutils.image.ImageOptions;
import org.xutils.x;

public class MainActivity extends AppCompatActivity {

    CircleImageView circleImageViewGlide;

    RoundImageView roundImageViewPicasso;
    RoundImageView roundImageViewXutils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circleImageViewGlide = (CircleImageView) findViewById(R.id.circle_image_glide);
        roundImageViewPicasso = (RoundImageView) findViewById(R.id.round_image_picasso);
        roundImageViewXutils = (RoundImageView) findViewById(R.id.round_image_xutils);

        Glide.with(this).load("http://img2.imgtn.bdimg.com/it/u=1939271907,257307689&fm=21&gp=0.jpg").into(circleImageViewGlide);

        Picasso.with(this).load("http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg").fit().into(roundImageViewPicasso);

        x.image().bind(roundImageViewXutils, "http://img0.imgtn.bdimg.com/it/u=2263418180,3668836868&fm=206&gp=0.jpg",
                new ImageOptions.Builder().setCrop(true).build());
    }
}
