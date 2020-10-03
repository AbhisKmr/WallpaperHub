package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.os.Bundle;
import android.provider.Settings;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.weekModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String JSON_URL = "https://raw.githubusercontent.com/AbhisKmr/alpha/master/wallpaperHubWeek.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<weekModel> weekLst;
    private RecyclerView recyclerView;
    private BottomNavigationView mNavView;
    private FrameLayout frameLayout;
    private HomeFragment homeFragment;
    private BrowseFragment browseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavView = findViewById(R.id.main_nav);
        frameLayout =findViewById(R.id.main_frame);

        String android_id = Settings.Secure.getString(this.getContentResolver(),Settings.Secure.ANDROID_ID);

//        myRef.setValue(android_id);

        homeFragment = new HomeFragment();
        browseFragment = new BrowseFragment();

        setFragment(homeFragment);

        mNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home_nav:
                        setFragment(homeFragment);
                        return true;

                    case R.id.browse_nav:
                        setFragment(browseFragment);
                        return true;

                    case R.id.download_nav:
                        Toast.makeText(MainActivity.this, "Bad request", Toast.LENGTH_SHORT).show();


                        default:
                            return false;

                }
            }
        });


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }

}

