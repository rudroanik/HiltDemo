package com.anikroy.hiltdemo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.anikroy.hiltdemo.R;
import com.anikroy.hiltdemo.viewmodel.PostViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);

        postViewModel.getPosts().observe(this,posts -> Toast.makeText(this, String.valueOf(posts.size()), Toast.LENGTH_SHORT).show());

    }
}