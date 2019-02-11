package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

public class Home_Page_Activity extends AppCompatActivity {

    private List<weekModel> weekLst;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page_);


        weekLst = new ArrayList<>();
        recyclerView = findViewById(R.id.weekRecycler);
        jsonrequest();
    }

    private void jsonrequest() {
        String JSON_URL = "https://raw.githubusercontent.com/AbhisKmr/alpha/master/wallpaperHubWeek.json";
        JsonArrayRequest request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        weekModel week_Model = new weekModel();
                        week_Model.setLikes(jsonObject.getString("likes"));
                        week_Model.setDownloads(jsonObject.getString("likes"));
                        week_Model.setDay(jsonObject.getString("day"));
                        week_Model.setImg_url(jsonObject.getString("img"));
                        weekLst.add(week_Model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecycler(weekLst);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(Home_Page_Activity.this);
        requestQueue.add(request);
    }

    private void setuprecycler(List<weekModel> weekLst) {
        weekAdapter week_adapet = new weekAdapter(this, weekLst);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(week_adapet);
    }
}


