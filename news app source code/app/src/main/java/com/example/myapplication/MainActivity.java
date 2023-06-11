package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.NewsAdapter.OnNewsSelectedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnNewsSelectedListener {
    private RecyclerView topStoriesRecyclerView, newsRecyclerView;
    TopStoriesAdapter topStoriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topStoriesRecyclerView = findViewById(R.id.top_stories_recycler_view);
        newsRecyclerView = findViewById(R.id.news_recycler_view);

        // Initialize top stories list and adapter
        List<News> topStoriesList = new ArrayList<>();
        topStoriesList.add(new News("BBC News", R.drawable.ts_1, "White House and Republican negotiators have resumed US debt "));
        topStoriesList.add(new News("BBC News", R.drawable.ts_2,"When Turkish voters return to the polls in a week's time to pick a president"));
        topStoriesList.add(new News("BBC News", R.drawable.ts_3, "Toshiyuki Mimaki says he remembers crying as he looked up at a blackened"));
        topStoriesList.add(new News("BBC News", R.drawable.ts_4, "A Washington DC police officer who was given an award "));
        topStoriesList.add(new News("BBC News", R.drawable.ts_5, "President Bashar al-Assad strode into the Arab League summit in Jeddah"));


        // Initialize news list and adapter
        List<News> newsList = new ArrayList<>();
        newsList.add(new News("BBC News", R.drawable.nn1, "Turkey's current president, Recep Tayyip Erdogan, has been in power for two decades"));
        newsList.add(new News("CNN", R.drawable.nn2, "Toshiyuki Mimaki says he remembers crying as he looked up"));
        newsList.add(new News("7 News", R.drawable.nn3, "The US says it will allow its Western allies to supply Ukraine with advanced fighter jets"));
        newsList.add(new News("BBC News", R.drawable.nn4, "G7 leaders sent a strong message to Russia by inviting Volodymyr Zelensky to Hiroshima"));
        newsList.add(new News("BBC News", R.drawable.nn5, "A powerful earthquake hit southeast Turkey"));
        newsList.add(new News("CNN", R.drawable.nn6, "Can ‘enhanced rock weathering’ help combat climate change?"));
        newsList.add(new News("BBC News", R.drawable.nn1, "Turkey's current president, Recep Tayyip Erdogan, has been in power for two decades"));
        newsList.add(new News("CNN", R.drawable.nn2, "Toshiyuki Mimaki says he remembers crying as he looked up"));
        newsList.add(new News("7 News", R.drawable.nn3, "The US says it will allow its Western allies to supply Ukraine with advanced fighter jets"));
        newsList.add(new News("BBC News", R.drawable.nn4, "G7 leaders sent a strong message to Russia by inviting Volodymyr Zelensky to Hiroshima"));

        topStoriesAdapter = new TopStoriesAdapter(this, topStoriesList, this);
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        topStoriesRecyclerView.setAdapter(topStoriesAdapter);


        newsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        newsRecyclerView.setAdapter(new NewsAdapter(this, newsList, this));
    }

    @Override
    public void onNewsSelected(News news) {
        loadNews(news);
    }

    public void loadNews(News news) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle b = new Bundle();
        b.putSerializable(NewsDetailFragment.NEWS, news);
        fragment.setArguments(b);
        fragmentTransaction.add(R.id.fr_container, fragment, "test").addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        topStoriesAdapter.notifyDataSetChanged();
    }
}

