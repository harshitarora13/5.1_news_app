package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.NewsAdapter.OnNewsSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment implements OnNewsSelectedListener {
    public static final String NEWS = "news";
    private ImageView newsIv;
    private TextView descTv;
    private RecyclerView relatedNewsRecyclerView;
    News selectedNews;

    public NewsDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            selectedNews = (News) getArguments().getSerializable(NEWS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);
        newsIv = view.findViewById(R.id.news_iv);
        descTv = view.findViewById(R.id.desc_tv);

        newsIv.setImageResource(selectedNews.getImageResource());
        descTv.setText(selectedNews.getDescription());

        relatedNewsRecyclerView = view.findViewById(R.id.related_news_recycler_view);
        relatedNewsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        relatedNewsRecyclerView.setAdapter(new RelatedNewsAdapter(getActivity(), getRelatedNewsList(), this));
        return view;
    }

    private List<News> getRelatedNewsList() {
        // Implement the logic to fetch and return the related news based on the provided top story
        // You can make API calls, query a database, or use any other data retrieval method here
        // Return a list of NewsItem objects
        // Example implementation:
        List<News> relatedNewsList = new ArrayList<>();
        relatedNewsList.add(new News("BBC News", R.drawable.ts_1, "White House and Republican negotiators have resumed US debt"));
        relatedNewsList.add(new News("CNN", R.drawable.ts_2, "When Turkish voters return to the polls in a week's time to pick a president"));
        relatedNewsList.add(new News("7 News", R.drawable.ts_3, "Toshiyuki Mimaki says he remembers crying as he looked up at a blackened"));
        relatedNewsList.add(new News("BBC News", R.drawable.ts_4, "A Washington DC police officer who was given an award "));
        relatedNewsList.add(new News("CNN", R.drawable.ts_5, "President Bashar al-Assad strode into the Arab League summit in Jeddah "));
        relatedNewsList.add(new News("7 News", R.drawable.nn5, "A powerful earthquake hit southeast Turkey "));
        relatedNewsList.add(new News("BBC News", R.drawable.nn6, "Can ‘enhanced rock weathering’ help combat climate change?"));

        return relatedNewsList;
    }

    @Override
    public void onNewsSelected(News news) {
        ((MainActivity) getActivity()).loadNews(news);
    }
}
