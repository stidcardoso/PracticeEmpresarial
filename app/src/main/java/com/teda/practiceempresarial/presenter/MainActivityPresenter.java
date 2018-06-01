package com.teda.practiceempresarial.presenter;

import android.util.Log;

import com.teda.practiceempresarial.model.Road;
import com.teda.practiceempresarial.net.GmapAPIClient;
import com.teda.practiceempresarial.net.GmapAPIListener;

/**
 * Created by anime on 30/05/2018.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private MainActivityContract.View view;
    private GmapAPIClient gmapAPIClient;

    public MainActivityPresenter() {
        gmapAPIClient = new GmapAPIClient(gmapAPIListener);
    }

    @Override
    public void setView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void calculateDistance(String origin, String destination) {
        gmapAPIClient.calculateDistance(origin, destination);
    }

    private GmapAPIListener gmapAPIListener = new GmapAPIListener() {

        @Override
        public void onCalculateDistanceSuccess(Road road) {
            view.goToDetails(road);
        }

        @Override
        public void onCalculateDistanceError(int error) {
            Log.d("Error", "error");
        }
    };
}
