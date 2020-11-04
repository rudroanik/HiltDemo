package com.anikroy.hiltdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.anikroy.hiltdemo.R;
import com.anikroy.hiltdemo.databinding.ItemPostBinding;
import com.anikroy.hiltdemo.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<Post> posts;
    private Context context;

    public PostAdapter(List<Post> posts,Context context) {
        this.posts = posts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPostBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_post,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);

        holder.postBinding.id.setText(String.valueOf(post.getId()));
        holder.postBinding.title.setText(post.getTitle());
        holder.postBinding.description.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemPostBinding postBinding;
        public ViewHolder(ItemPostBinding postBinding) {
            super(postBinding.getRoot());
            this.postBinding = postBinding;
        }
    }
}
