package com.anikroy.hiltdemo.di;

import androidx.lifecycle.MutableLiveData;

import com.anikroy.hiltdemo.model.Post;

import java.util.List;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@InstallIn(ApplicationComponent.class)
@Module
public class RepositoryModule {

    @Provides
    public MutableLiveData<List<Post>> postList(){

        return new MutableLiveData<>();
    }
}
