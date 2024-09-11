package com.example.androidjava.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.example.androidjava.Activity.DetailActivity;
import com.example.androidjava.Domain.PopularDomain;
import com.example.androidjava.R;

import java.util.ArrayList;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.Viewolder> {
    ArrayList<PopularDomain> items;
    Context context;


    public PopularListAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularListAdapter.Viewolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list, parent, false);
        context = parent.getContext();
        return new Viewolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularListAdapter.Viewolder holder, int position) {
        holder.txttitle.setText(items.get(position).getTitle());
        holder.txtFee.setText("$"+items.get(position).getPrice());
        holder.txtScore.setText(""+items.get(position).getScore());

        int drawbleResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),
                "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawbleResourceId)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.pic);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewolder extends  RecyclerView.ViewHolder{
        TextView txttitle, txtFee, txtScore;
        ImageView pic;
        public Viewolder(@NonNull View itemView) {
            super(itemView);

            txttitle= itemView.findViewById(R.id.txttitle);
            txtFee= itemView.findViewById(R.id.txtfee);
            txtScore= itemView.findViewById(R.id.txtscore);
            pic=itemView.findViewById(R.id.pic);

        }
    }
}
