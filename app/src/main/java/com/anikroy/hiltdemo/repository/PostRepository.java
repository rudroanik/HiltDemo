package com.anikroy.hiltdemo.repository;

import androidx.lifecycle.MutableLiveData;

import com.anikroy.hiltdemo.Interface.ApiInterface;
import com.anikroy.hiltdemo.model.Post;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository {

    ApiInterface apiInterface;
    MutableLiveData<List<Post>> postList;

    @Inject
    public PostRepository(ApiInterface apiInterface,MutableLiveData<List<Post>> post) {
        this.apiInterface = apiInterface;
        this.postList = post;
    }

    public MutableLiveData<List<Post>> getPosts(){
        Call<List<Post>> call = apiInterface.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()){
                    postList.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });

        return postList;
    }
}
