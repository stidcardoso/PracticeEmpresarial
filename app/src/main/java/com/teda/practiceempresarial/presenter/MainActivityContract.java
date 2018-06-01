package com.teda.practiceempresarial.presenter;

import com.google.gson.JsonObject;
import com.teda.practiceempresarial.model.Road;

/**
 * Created by anime on 30/05/2018.
 */

public interface MainActivityContract {

    interface View {

        void goToDetails(Road road);

    }

    interface Presenter {

        void setView(View view);

        void calculateDistance(String origin, String destination);

    }

}
