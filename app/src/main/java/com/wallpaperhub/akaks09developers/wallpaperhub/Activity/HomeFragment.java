package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.wallpaperhub.akaks09developers.wallpaperhub.Adapter.weekAdapter;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.adventure;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.baby;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.flowers;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.food;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.friend;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.music;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.nature;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.night;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.old;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.portrait;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.road;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.water;
import com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity.wildlife;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.weekModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private List<weekModel> weekLst;
    private RecyclerView recyclerView;
    ImageView wOtd,flrImg, foddImg, frndImg, babyImg, ntrImg, mscImg, trvlImg, nghtImg, oldImg, prtrImg, roadImg, wtrImg, wildImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //Category Activity function Start)

        flrImg = view.findViewById(R.id.flr);
        flrImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), flowers.class);
                startActivity(intent);
            }
        });

        foddImg = view.findViewById(R.id.food);
        foddImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), food.class);
                startActivity(intent);
            }
        });

        frndImg = view.findViewById(R.id.frnd);
        frndImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), friend.class);
                startActivity(intent);
            }
        });

        babyImg = view.findViewById(R.id.baby);
        babyImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), baby.class);
                startActivity(intent);
            }
        });

        ntrImg = view.findViewById(R.id.ntr);
        ntrImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), nature.class);
                startActivity(intent);
            }
        });

        mscImg = view.findViewById(R.id.music);
        mscImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), music.class);
                startActivity(intent);
            }
        });

        trvlImg = view.findViewById(R.id.trll);
        trvlImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), adventure.class);
                startActivity(intent);
            }
        });

        nghtImg = view.findViewById(R.id.nght);
        nghtImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), night.class);
                startActivity(intent);
            }
        });

        oldImg = view.findViewById(R.id.oldgld);
        oldImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), old.class);
                startActivity(intent);
            }
        });

        prtrImg = view.findViewById(R.id.pp);
        prtrImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), portrait.class);
                startActivity(intent);

            }
        });

        roadImg = view.findViewById(R.id.road);
        roadImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), road.class);
                startActivity(intent);
            }
        });

        wtrImg = view.findViewById(R.id.undwtr);
        wtrImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), water.class);
                startActivity(intent);
            }
        });

        wildImg = view.findViewById(R.id.wildlf);
        wildImg.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void  onClick(View view1){
                Intent intent = new Intent(getActivity(), wildlife.class);
                startActivity(intent);
            }
        });
        //Category Activity function End


        weekLst = new ArrayList<>();
        recyclerView = view.findViewById(R.id.weekRecycler);
        jsonrequest();
        return view;

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
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);
    }

    private void setuprecycler(List<weekModel> weekLst) {
        weekAdapter week_adapet = new weekAdapter(getContext(), weekLst);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(week_adapet);
    }




}
