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

import com.example.myapplication.NewsAdapter.OnNewsSelectedListener;

import java.util.List;

public class RelatedNewsAdapter extends RecyclerView.Adapter<RelatedNewsAdapter.ViewHolder> {
    private Context context;
    private List<News> newsList;
    OnNewsSelectedListener listener;

    public RelatedNewsAdapter(Context context, List<News> newsList, OnNewsSelectedListener listener) {
        this.context = context;
        this.newsList = newsList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_related_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.titleTv.setText(news.getChannelName());
        holder.newsImageView.setImageResource(news.getImageResource());
        holder.descriptionTextView.setText(news.getDescription());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewsSelected(newsList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImageView;
        TextView descriptionTextView, titleTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImageView = itemView.findViewById(R.id.news_iv);
            titleTv = itemView.findViewById(R.id.title_tv);
            descriptionTextView = itemView.findViewById(R.id.description_tv);
        }
    }
}
