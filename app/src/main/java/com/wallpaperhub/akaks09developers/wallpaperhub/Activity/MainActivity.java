package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.app.Activity;
import android.app.Notification;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.wallpaperhub.akaks09developers.wallpaperhub.Adapter.weekAdapter;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.weekModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String JSON_URL = "https://raw.githubusercontent.com/AbhisKmr/alpha/master/wallpaperHubWeek.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<weekModel> weekLst;
    private RecyclerView recyclerView;
    //////////////
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

