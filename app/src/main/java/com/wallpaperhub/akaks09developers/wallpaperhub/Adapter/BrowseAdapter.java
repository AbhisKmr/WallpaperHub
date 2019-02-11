package com.wallpaperhub.akaks09developers.wallpaperhub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wallpaperhub.akaks09developers.wallpaperhub.Activity.weekFullView;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.BrowseModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.weekModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import java.util.List;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.BrowseHolder>{

    private Context bContext;
    private List<BrowseModel> bData;
    RequestOptions b_options;

    public BrowseAdapter(Context bContext, List<BrowseModel> list) {
        this.bContext = bContext;
        this.bData = list;
        b_options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_broken_image).error(R.drawable.ic_broken_image);

    }

    @NonNull
    @Override
    public BrowseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(bContext);
        view = inflater.inflate(R.layout.browse_item, parent, false);
        final BrowseHolder browseHolder = new BrowseHolder(view);
        browseHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bContext, weekFullView.class);
                intent.putExtra("image_link",bData.get(browseHolder.getAdapterPosition()).getImage_link());
                bContext.startActivity(intent);
            }
        });


        return browseHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseHolder holder, int position) {
        Glide.with(bContext).load(bData.get(position).getImage_link()).apply(b_options).into(holder.B_imageView);


    }

    @Override
    public int getItemCount() {
        return bData.size();
    }

    public static class BrowseHolder extends RecyclerView.ViewHolder {
        ImageView B_imageView ;
        RelativeLayout relativeLayout;

        public BrowseHolder(View itemView) {
            super(itemView);
            B_imageView = itemView.findViewById(R.id.b_imgV);
            relativeLayout = itemView.findViewById(R.id.B_rel);
        }
    }
}
