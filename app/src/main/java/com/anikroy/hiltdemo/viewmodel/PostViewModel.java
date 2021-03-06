package com.anikroy.hiltdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.anikroy.hiltdemo.model.Post;
import com.anikroy.hiltdemo.repository.PostRepository;

import java.util.List;

public class PostViewModel extends AndroidViewModel {

    PostRepository postRepository;
    @ViewModelInject
    public PostViewModel(@NonNull Application application,PostRepository postRepository) {
        super(application);
        this.postRepository =postRepository;
    }

    public MutableLiveData<List<Post>> getPosts(){

        return postRepository.getPosts();
    }

}
