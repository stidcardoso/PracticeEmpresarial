package com.teda.practiceempresarial;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.teda.practiceempresarial.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anime on 30/05/2018.
 */

public class PracticeEmpresarialApplication extends Application {

    private static Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofit = createRetrofit();
    }

    public static Retrofit createRetrofit() {
        Gson gson = new GsonBuilder().create();

        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
