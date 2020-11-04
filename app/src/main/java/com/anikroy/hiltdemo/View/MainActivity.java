package com.anikroy.hiltdemo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.anikroy.hiltdemo.R;
import com.anikroy.hiltdemo.adapter.PostAdapter;
import com.anikroy.hiltdemo.databinding.ActivityMainBinding;
import com.anikroy.hiltdemo.viewmodel.PostViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getPosts().observe(this,posts -> {
            PostAdapter postAdapter = new PostAdapter(posts,this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            binding.rvPost.setLayoutManager(mLayoutManager);
            binding.rvPost.setAdapter(postAdapter);
        });
    }
}