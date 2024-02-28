package com.example.mobiledoan.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mobiledoan.MyExoplayer;
import com.example.mobiledoan.PlayerActivity;
import com.example.mobiledoan.Activity.SongListActivity;
import com.example.mobiledoan.databinding.SongListItemRecyclerRowBinding;
import com.example.mobiledoan.Models.SongModel;

import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.MyViewHolder> {
    private final List<String> songIdList;

    public SongListAdapter(List<String> songIdList) {
        this.songIdList = songIdList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final SongListItemRecyclerRowBinding binding;

        public MyViewHolder(@NonNull SongListItemRecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(String songId) {
            FirebaseFirestore.getInstance().collection("songs")
                    .document(songId).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        SongModel song = documentSnapshot.toObject(SongModel.class);
                        if (song != null) {
                            binding.songTitleTextView.setText(song.getTitle());
                            binding.songSubtitleTextView.setText(song.getSubtitle());
                            Glide.with(binding.songCoverImageView).load(song.getCoverURL())
                                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(32)))
                                    .into(binding.songCoverImageView);
                            binding.getRoot().setOnClickListener(view -> {
                                MyExoplayer.startPlaying(view.getContext(), song);
                                view.getContext().startActivity(new Intent(view.getContext(), PlayerActivity.class));
                            });
                        }
                    });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SongListItemRecyclerRowBinding binding = SongListItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public int getItemCount() {
        return songIdList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bindData(songIdList.get(position));
    }
}


