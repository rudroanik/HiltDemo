package com.anikroy.hiltdemo.Interface;

import com.anikroy.hiltdemo.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("posts")
    Call<List<Post>> getPosts();
}
