package com.example.mobiledoan;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.media3.exoplayer.ExoPlayer;
import com.example.mobiledoan.Models.SongModel;

public class MyExoplayer {
    private static ExoPlayer exoPlayer = null;
    private static SongModel currentSong = null;

    public static SongModel getCurrentSong() {
        return currentSong;
    }

    public static ExoPlayer getInstance() {
        return exoPlayer;
    }

    @SuppressLint("SuspiciousIndentation")
    public static void startPlaying(Context context, SongModel song) {
        if (exoPlayer == null)
            exoPlayer = new ExoPlayer.Builder(context).build();
        if (!song.equals(currentSong)) {
            currentSong = song;
            if (currentSong.getUrl() != null) {
                androidx.media3.common.MediaItem mediaItem = androidx.media3.common.MediaItem.fromUri(currentSong.getUrl());
                exoPlayer.setMediaItem(mediaItem);
                exoPlayer.prepare();
                exoPlayer.play();
            }
        }
    }
}

