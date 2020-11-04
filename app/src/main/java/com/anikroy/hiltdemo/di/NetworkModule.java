package com.anikroy.hiltdemo.di;

import com.anikroy.hiltdemo.Interface.ApiInterface;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InstallIn(ApplicationComponent.class)
@Module
public class NetworkModule {

    @Provides
    public String provideBaseUrl(){

        return "https://jsonplaceholder.typicode.com/";
    }

    @Provides
    public Converter.Factory provideConverterFactory(){
        return GsonConverterFactory.create();
    }

    @Provides
    public Retrofit provideRetrofit(String baseUrl,Converter.Factory converterFactory){

        return new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(converterFactory).build();

    }

    @Provides
    public ApiInterface provideApiInterface(Retrofit retro){
        return retro.create(ApiInterface.class);
    }
}
