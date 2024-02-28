package com.example.mobiledoan;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.media3.exoplayer.ExoPlayer;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mobiledoan.Models.SongModel;
import com.example.mobiledoan.databinding.ActivityPlayerBinding;

public class PlayerActivity extends AppCompatActivity {
    private ActivityPlayerBinding binding;
    private ExoPlayer exoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SongModel currentSong = MyExoplayer.getCurrentSong();
        if (currentSong != null) {
            binding.songTitleTextView.setText(currentSong.getTitle());
            binding.songSubtitleTextView.setText(currentSong.getSubtitle());
            Glide.with(binding.songCoverImageView)
                    .load(currentSong.getCoverURL())
                    .circleCrop()
                    .into(binding.songCoverImageView);
            exoPlayer = MyExoplayer.getInstance();
            binding.playerView.setPlayer(exoPlayer);
            binding.playerView.showController();
        }
    }
}


