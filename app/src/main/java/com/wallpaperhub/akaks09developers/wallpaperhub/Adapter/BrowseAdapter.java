package com.wallpaperhub.akaks09developers.wallpaperhub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wallpaperhub.akaks09developers.wallpaperhub.Activity.weekFullView;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.BrowseModel;
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
                intent.putExtra("img_url",bData.get(browseHolder.getAdapterPosition()).getB_img());
                bContext.startActivity(intent);
            }
        });
        return browseHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseHolder holder, int position) {
        Glide.with(bContext).load(bData.get(position).getB_img()).apply(b_options).into(holder.B_imageView);

    }

    @Override
    public int getItemCount() {
        return bData.size();
    }

    public static class BrowseHolder extends RecyclerView.ViewHolder {
        ImageView B_imageView ;
        ConstraintLayout relativeLayout;

        public BrowseHolder(View itemView) {
            super(itemView);
            B_imageView = itemView.findViewById(R.id.b_imgV);
            relativeLayout = itemView.findViewById(R.id.B_rel);
        }
    }
}
