package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

public class BrowseFullView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_full_view);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String imageUrl = getIntent().getExtras().getString("image_link");
        ImageView bImg = findViewById(R.id.brFullV);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_broken_image).error(R.drawable.ic_broken_image);
        Glide.with(this).load(imageUrl).apply(requestOptions).into(bImg);


    }
}

