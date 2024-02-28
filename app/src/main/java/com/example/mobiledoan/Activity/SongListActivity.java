package com.example.mobiledoan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mobiledoan.Adapter.SongListAdapter;
import com.example.mobiledoan.Models.CategoryModel;
import com.example.mobiledoan.databinding.ActivitySongListBinding;

public class SongListActivity extends AppCompatActivity {

    public static CategoryModel category;

    private ActivitySongListBinding binding;

    private SongListAdapter songListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySongListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.nameTextView.setText(category.getName());
        Glide.with(binding.coverImageView).load(category.getCoverURL())
                .apply(new RequestOptions().transform(new RoundedCorners(32)))
                .into(binding.coverImageView);
        setupSongsListRecyclerView();
    }

    private void setupSongsListRecyclerView() {
        songListAdapter = new SongListAdapter(category.getSongs());
        binding.songListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.songListRecyclerView.setAdapter(songListAdapter);
    }
}