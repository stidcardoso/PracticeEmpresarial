package com.teda.practiceempresarial.net;

import com.google.gson.JsonObject;
import com.teda.practiceempresarial.model.Road;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by anime on 30/05/2018.
 */

public interface GmapAPI {

    @GET("json")
    Call<Road> calculateDistance(@Query("units") String units,
                                 @Query("origins") String origin,
                                 @Query("destinations") String destination,
                                 @Query("key") String key);
}
