package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

public class BrowseFullView extends AppCompatActivity {

    FloatingActionButton fab_more, Fab_download, Fab_Share, FabSetW;
    Animation FabOpen, FabClose, FabRClockwise, FabRAnticlockwise;
    boolean isOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_full_view);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String imageUrl = getIntent().getExtras().getString("image_link");
        ImageView bImg = findViewById(R.id.brFullV);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.ic_broken_image).error(R.drawable.ic_broken_image);
        Glide.with(this).load(imageUrl).apply(requestOptions).into(bImg);


        //get fab button
        fab_more = findViewById(R.id.fab_more);
        Fab_download = findViewById(R.id.fab_download);
        Fab_Share = findViewById(R.id.fab_share);
        FabSetW = findViewById(R.id.fab_setWallpaper);

        //floating Button Animation
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_colse);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        FabRAnticlockwise = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);

        fab_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen) {
                    Fab_download.startAnimation(FabClose);
                    Fab_Share.startAnimation(FabClose);
                    FabSetW.startAnimation(FabClose);
                    fab_more.startAnimation(FabRAnticlockwise);
                    Fab_download.setClickable(false);
                    Fab_Share.setClickable(false);
                    FabSetW.setClickable(false);
                    isOpen = false;

                } else {
                    Fab_download.startAnimation(FabOpen);
                    Fab_Share.startAnimation(FabOpen);
                    FabSetW.startAnimation(FabOpen);
                    fab_more.startAnimation(FabRClockwise);
                    Fab_download.setClickable(true);
                    Fab_Share.setClickable(true);
                    FabSetW.setClickable(true);
                    isOpen = true;
                }
            }
        });


    }
}

