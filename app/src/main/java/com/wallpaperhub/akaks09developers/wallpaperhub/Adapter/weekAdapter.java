package com.wallpaperhub.akaks09developers.wallpaperhub.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.wallpaperhub.akaks09developers.wallpaperhub.Activity.weekFullView;
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.weekModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import java.util.List;

public class weekAdapter extends RecyclerView.Adapter<weekAdapter.W_ItemHolder> {

    private Context mContext;
    private List<weekModel> mData;
    RequestOptions options;

    public weekAdapter(Context mContext, List<weekModel> mData) {
        this.mContext = mContext;
        this.mData = mData;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_broken_image).error(R.drawable.ic_broken_image);
    }

    @NonNull
    @Override
    public W_ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.week_item, parent, false);
        final W_ItemHolder wItemHolder = new W_ItemHolder(view);
        wItemHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, weekFullView.class);
                intent.putExtra("img_url", mData.get(wItemHolder.getAdapterPosition()).getImg_url());
                mContext.startActivity(intent);
            }
        });
        return wItemHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull W_ItemHolder holder, int position) {
//        holder.LikeTv.setText(mData.get(position).getLikes());
//        holder.DownloadTv.setText(mData.get(position).getDownloads());
//        holder.DatTv.setText(mData.get(position).getDay());
        Glide.with(mContext).load(mData.get(position).getImg_url()).apply(options).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class W_ItemHolder extends RecyclerView.ViewHolder {
//        TextView LikeTv, DownloadTv, DatTv;
        ImageView imageView;
        LinearLayout cardView;

        public W_ItemHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.weekImg);
            cardView = itemView.findViewById(R.id.weekCard);
//            LikeTv = itemView.findViewById(R.id.)
        }
    }
}