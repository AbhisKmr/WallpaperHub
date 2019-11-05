package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.Manifest;
import android.app.DownloadManager;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import java.io.IOException;

public class BrowseFullView extends AppCompatActivity {

    FloatingActionButton fab_more, Fab_download, Fab_Share, FabSetW;
    Animation FabOpen, FabClose, FabRClockwise, FabRAnticlockwise;
    boolean isOpen = false;
    private static int REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_full_view);

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        }, REQUEST_CODE);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        final String imageUrl = getIntent().getExtras().getString("image_link");
        final ImageView bImg = findViewById(R.id.brFullV);

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
                    FabSetW.startAnimation(FabClose);
                    fab_more.startAnimation(FabRAnticlockwise);
                    Fab_download.setClickable(false);
                    FabSetW.setClickable(false);
                    isOpen = false;

                } else {
                    Fab_download.startAnimation(FabOpen);
                    FabSetW.startAnimation(FabOpen);
                    fab_more.startAnimation(FabRClockwise);
                    Fab_download.setClickable(true);
                    FabSetW.setClickable(true);
                    isOpen = true;
                }
            }
        });

        FabSetW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BrowseFullView.this, "Please wait", Toast.LENGTH_SHORT).show();
                Bitmap bitmapImg = ((BitmapDrawable) bImg.getDrawable()).getBitmap();

                WallpaperManager wallManager = WallpaperManager.getInstance(getApplicationContext());
                try {
//                    wallManager.clear();
                    wallManager.setBitmap(bitmapImg);
                    Toast.makeText(BrowseFullView.this, "Wallpaper set", Toast.LENGTH_SHORT).show();


                } catch (IOException ex) {

                }
            }
        });
        Fab_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Downloading File",
                        Toast.LENGTH_LONG).show();
                // Download here using downloadUrl
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(imageUrl));
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.
                        Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir("/Download", "wallpaperHub.jpg");
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);


            }
        });

//        Fab_Share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBody = "Download awsome wallpaper from WallpaperHub ";
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody + imageUrl);
//                startActivity(Intent.createChooser(sharingIntent, "Share via"));
//            }
//        });


    }
}

