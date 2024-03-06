package com.example.mobiledoan.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.mobiledoan.Activity.SongListActivity;
import com.example.mobiledoan.databinding.CategoryItemRecyclerRowBinding;
import com.example.mobiledoan.Models.CategoryModel;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private List<CategoryModel> categoryList;

    public CategoryAdapter(List<CategoryModel> categoryList) {
        this.categoryList = categoryList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private CategoryItemRecyclerRowBinding binding;

        public MyViewHolder(CategoryItemRecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindData(CategoryModel category) {
            binding.nameTextView.setText(category.getName());
            Glide.with(binding.coverImageView.getContext())
                    .load(category.getCoverURL())
                    .apply(new RequestOptions().transform(new RoundedCorners(32)))
                    .into(binding.coverImageView);
            binding.getRoot().setOnClickListener(v -> {
                SongListActivity.category = category;
                v.getContext().startActivity(new Intent(v.getContext(), SongListActivity.class));
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CategoryItemRecyclerRowBinding binding = CategoryItemRecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindData(categoryList.get(position));
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}



