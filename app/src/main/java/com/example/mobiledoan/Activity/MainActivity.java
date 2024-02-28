package com.example.mobiledoan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.mobiledoan.Adapter.SectionSongListAdapter;
import com.example.mobiledoan.Models.SongModel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mobiledoan.Adapter.CategoryAdapter;
import com.example.mobiledoan.Models.CategoryModel;
import com.example.mobiledoan.MyExoplayer;
import com.example.mobiledoan.PlayerActivity;
import com.example.mobiledoan.R;
import com.example.mobiledoan.databinding.ActivityMainBinding;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CategoryAdapter categoryAdapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getCategories();
        setupSection("section_1", binding.section1MainLayout, binding.section1Title, binding.section1RecyclerView);
        setupSection("section_2", binding.section2MainLayout, binding.section2Title, binding.section2RecyclerView);
        ImageSlider imageSlider = findViewById(R.id.imageSlider);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.msev, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.msev2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.msev3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.msev4, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showPlayerView();
    }

    private void showPlayerView() {
        binding.playerView.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, PlayerActivity.class)));
        SongModel currentSong = MyExoplayer.getCurrentSong();
        if (currentSong != null) {

            binding.playerView.setVisibility(View.VISIBLE);
            binding.songTitleTextView.setText("Now playing :" + currentSong.getTitle());
            Glide.with(binding.songCoverImageView)
                    .load(currentSong.getCoverURL())
                    .apply(new RequestOptions().transform(new RoundedCorners(32)))
                    .into(binding.songCoverImageView);
        } else {
            binding.playerView.setVisibility(View.GONE);
        }
    }

    private void getCategories() {
        FirebaseFirestore.getInstance().collection("category")
                .get().addOnSuccessListener(queryDocumentSnapshots -> {
                    List<CategoryModel> categoryList = queryDocumentSnapshots.toObjects(CategoryModel.class);
                    setupCategoryRecyclerView(categoryList);
                });
    }
    private void setupCategoryRecyclerView(List<CategoryModel> categoryList) {
        categoryAdapter = new CategoryAdapter(categoryList);
        binding.categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        binding.categoriesRecyclerView.setAdapter(categoryAdapter);
    }

    private void setupSection(String id, RelativeLayout mainLayout, TextView titleView, RecyclerView recyclerView) {
        FirebaseFirestore.getInstance().collection("sections")
                .document(id)
                .get().addOnSuccessListener(documentSnapshot -> {
                    CategoryModel section = documentSnapshot.toObject(CategoryModel.class);
                    if (section != null) {
                        mainLayout.setVisibility(View.VISIBLE);
                        titleView.setText(section.getName());
                        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));
                        recyclerView.setAdapter(new SectionSongListAdapter(section.getSongs()));
                        mainLayout.setOnClickListener(v -> {
                            SongListActivity.category = section;
                            startActivity(new Intent(MainActivity.this, SongListActivity.class));
                        });
                    }
                });
    }
}

