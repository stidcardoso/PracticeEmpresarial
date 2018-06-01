package com.teda.practiceempresarial.net;

import com.teda.practiceempresarial.model.Road;
import com.teda.practiceempresarial.util.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.teda.practiceempresarial.PracticeEmpresarialApplication.getRetrofit;

/**
 * Created by anime on 30/05/2018.
 */

public class GmapAPIClient {

    private GmapAPI gmapAPI;
    private GmapAPIListener listener;

    public GmapAPIClient(GmapAPIListener listener) {
        gmapAPI = getRetrofit().create(GmapAPI.class);
        this.listener = listener;
    }

    public void calculateDistance(String origin, String destination) {
        gmapAPI.calculateDistance("imperial", origin, destination, Constants.KEY).enqueue(new Callback<Road>() {
            @Override
            public void onResponse(Call<Road> call, Response<Road> response) {
                if (response.isSuccessful()) {
                    listener.onCalculateDistanceSuccess(response.body());
                } else {
                    listener.onCalculateDistanceError(response.code());
                }
            }

            @Override
            public void onFailure(Call<Road> call, Throwable t) {
                listener.onCalculateDistanceError(500);
            }
        });
    }
}
