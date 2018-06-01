package com.teda.practiceempresarial.net;

import com.google.gson.JsonObject;
import com.teda.practiceempresarial.model.Road;

/**
 * Created by anime on 30/05/2018.
 */

public interface GmapAPIListener {

    void onCalculateDistanceSuccess(Road road);


    void onCalculateDistanceError(int error);

}
