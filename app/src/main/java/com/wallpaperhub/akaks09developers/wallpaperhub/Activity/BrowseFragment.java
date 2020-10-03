package com.wallpaperhub.akaks09developers.wallpaperhub.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wallpaperhub.akaks09developers.wallpaperhub.Adapter.BrowseAdapter;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.BrowseModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;
import com.wallpaperhub.akaks09developers.wallpaperhub.Utility.AppConstant;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class BrowseFragment extends Fragment {

    private List<BrowseModel> B_lst;
    private RecyclerView B_recyclerView;
    private Context context;
    BrowseAdapter browseAdapter;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference(AppConstant.SUPER_PARENT_KEY);

    public BrowseFragment(){

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View v = inflater.inflate(R.layout.fragment_browse, container, false);

        B_lst = new ArrayList<>();
        B_recyclerView = v.findViewById(R.id.B_Recycler);
        setuprecycler(B_lst);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                B_lst.clear();
                for (DataSnapshot ds : dataSnapshot.child(AppConstant.PARENT_KEY).child(AppConstant.BROWSE_KEY).getChildren()){
                    B_lst.add(ds.getValue(BrowseModel.class));
                }
                browseAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        return v;
    }

    private void setuprecycler(List<BrowseModel> b_lst) {
        browseAdapter = new BrowseAdapter(context,b_lst);
        B_recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        B_recyclerView.setAdapter(browseAdapter);
    }

}
