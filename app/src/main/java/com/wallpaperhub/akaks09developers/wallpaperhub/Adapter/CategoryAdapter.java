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
import com.wallpaperhub.akaks09developers.wallpaperhub.Model.CategoryModel;
import com.wallpaperhub.akaks09developers.wallpaperhub.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.myViewHolder>{

    private Context context;
    private List<CategoryModel> list;
    RequestOptions options;

    public CategoryAdapter(Context context, List<CategoryModel> list) {
        this.context = context;
        this.list = list;
        options = new RequestOptions().centerCrop().placeholder(R.drawable.ic_broken_image).error(R.drawable.ic_broken_image);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.browse_item,parent,false);
        final myViewHolder myViewHolder = new myViewHolder(view);
        myViewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, weekFullView.class);
                intent.putExtra("img_url",list.get(myViewHolder.getAdapterPosition()).getImage_link());
                context.startActivity(intent);
            }
        });

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        Glide.with(context).load(list.get(position).getImage_link()).apply(options).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout relativeLayout;
        ImageView imageView;


        public myViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.b_imgV);
            relativeLayout = itemView.findViewById(R.id.B_rel);
        }
    }

}
