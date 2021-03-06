package com.wallpaperhub.akaks09developers.wallpaperhub.Category_Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.wallpaperhub.akaks09developers.wallpaperhub.Adapter.CategoryAdapter;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.CategoryModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class wildlife extends AppCompatActivity {

    private final String JOSN_URL = "https://raw.githubusercontent.com/AbhisKmr/WallpaperHub/master/wallpaperHubAnimal.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<CategoryModel> categoryList;
    public RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildlife);
        categoryList = new ArrayList<>();

        recyclerView = findViewById(R.id.WildlifeRecycler);
        jsonrequest();
    }
    private void jsonrequest() {
        request= new JsonArrayRequest(JOSN_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;

                for (int i =0; i <response.length(); i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        CategoryModel categoryModel = new CategoryModel();
                        categoryModel.setImage_link(jsonObject.getString("b_img"));
                        categoryList.add(categoryModel);

                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                setupRecyclerView(categoryList);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue  = Volley.newRequestQueue(wildlife.this);
        requestQueue.add(request);
    }

    private void setupRecyclerView(List<CategoryModel> categoryList) {
        CategoryAdapter categoryAdapter =  new CategoryAdapter(this, categoryList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(categoryAdapter);
    }
}