package com.appham.projectviewer.api;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author thomas
 */

public class ApiFactory {


    public static ProjectsApi createProjectsApi() {
        return createRetrofit().create(ProjectsApi.class);
    }

    public static Retrofit createRetrofit() {
        return createRetrofit(createOkHttp());
    }

    public static OkHttpClient createOkHttp() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(ProjectsApi.USER, ProjectsApi.PASS))
                .addInterceptor(loggingInterceptor)
                .build();
    }

    public static Retrofit createRetrofit(@NonNull OkHttpClient okHttp) {
        return new Retrofit.Builder()
                .baseUrl(ProjectsApi.BASE_URL)
                .client(okHttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
