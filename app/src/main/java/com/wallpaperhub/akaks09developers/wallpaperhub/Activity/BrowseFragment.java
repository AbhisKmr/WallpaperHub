package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class BrowseFragment extends Fragment {
    private List<BrowseModel> B_lst;
    private RecyclerView B_recyclerView;
    public BrowseFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_browse, container, false);

        B_lst = new ArrayList<>();
        B_recyclerView = v.findViewById(R.id.B_Recycler);
        jsonrequest();
        return v;
    }


    private void jsonrequest() {
        String B_JSON_URL = "https://raw.githubusercontent.com/AbhisKmr/alpha/master/browse.json";
        JsonArrayRequest request = new JsonArrayRequest(B_JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int b = 0; b < response.length(); b++) {
                    try {
                        jsonObject = response.getJSONObject(b);
                        BrowseModel browseModel = new BrowseModel();
                        browseModel.setImage_link(jsonObject.getString("b_img"));
                        B_lst.add(browseModel);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setuprecycler(B_lst);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }

    private void setuprecycler(List<BrowseModel> b_lst) {
        BrowseAdapter browseAdapter = new BrowseAdapter(getContext(),b_lst);
        B_recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        B_recyclerView.setAdapter(browseAdapter);
    }

}
