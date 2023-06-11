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

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.ViewHolder> {
    private final Context context;
    private final List<News> topStories;
    private NewsAdapter.OnNewsSelectedListener listener;

    public TopStoriesAdapter(Context context, List<News> topStories, NewsAdapter.OnNewsSelectedListener listener) {
        this.context = context;
        this.topStories = topStories;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_top_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News topStory = topStories.get(position);
        holder.newsImage.setImageResource(topStory.getImageResource());
        holder.descTv.setText(topStory.getDescription());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onNewsSelected(topStory);
            }
        });
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newsImage;
        private TextView descTv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.top_story_image);
            descTv = itemView.findViewById(R.id.description_tv);
        }
    }


}
