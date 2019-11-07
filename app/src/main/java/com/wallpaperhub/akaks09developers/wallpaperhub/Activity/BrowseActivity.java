package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.wallpaperhub.akaks09developers.wallpaperhub.Adapter.BrowseAdapter;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.BrowseModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class BrowseActivity extends AppCompatActivity {

//    private List<BrowseModel> B_lst;
//    private RecyclerView B_recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

//        B_lst = new ArrayList<>();
//        B_recyclerView = findViewById(R.id.B_Recycler);
//        jsonrequest();

    }
//
//    private void jsonrequest() {
//        String B_JSON_URL = "https://raw.githubusercontent.com/AbhisKmr/alpha/master/browse_Jason.json";
//        JsonArrayRequest request = new JsonArrayRequest(B_JSON_URL, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                JSONObject jsonObject = null;
//                for (int b = 0; b < response.length(); b++) {
//                    try {
//                        jsonObject = response.getJSONObject(b);
//                        BrowseModel browseModel = new BrowseModel();
//                        browseModel.setImage_link(jsonObject.getString("b_img"));
//                        B_lst.add(browseModel);
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//                setuprecycler(B_lst);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        RequestQueue requestQueue = Volley.newRequestQueue(BrowseActivity.this);
//        requestQueue.add(request);
//    }
//
//    public void setuprecycler(List<BrowseModel> B_lst) {
//        BrowseAdapter browseAdapter = new BrowseAdapter(this, B_lst);
//        B_recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
//        B_recyclerView.setAdapter(browseAdapter);
//    }
}

















