package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    private static List<News> mNews;
    private Context mContext;
    private OnNewsSelectedListener listener;

    public NewsAdapter(Context context, List<News> news, OnNewsSelectedListener listener) {
        mNews = news;
        mContext = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News currentItem = mNews.get(position);
        holder.newsImageView.setImageResource(currentItem.getImageResource());
        holder.titleTv.setText(currentItem.getChannelName());
        holder.descTv.setText(currentItem.getDescription());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewsSelected(currentItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }


    public static class NewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView newsImageView;
        public TextView titleTv,descTv;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.news_iv);
            titleTv = itemView.findViewById(R.id.title_tv);
            descTv = itemView.findViewById(R.id.desc_tv);
        }
    }

    public interface OnNewsSelectedListener {
        void onNewsSelected(News news);
    }
}
