package com.teda.practiceempresarial.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.teda.practiceempresarial.R;
import com.teda.practiceempresarial.model.Road;
import com.teda.practiceempresarial.util.Constants;

/**
 * Created by anime on 30/05/2018.
 */

public class DetailsActivity extends AppCompatActivity {

    private TextView tvOrigin;
    private TextView tvDestination;
    private TextView tvDistance;
    private TextView tvDuration;
    private Road road;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        tvOrigin = findViewById(R.id.tv_origin);
        tvDestination = findViewById(R.id.tv_destination);
        tvDistance = findViewById(R.id.tv_distance);
        tvDuration = findViewById(R.id.tv_duration);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int distance;
            road = (Road) bundle.getSerializable(Constants.EXTRAS_ROAD);

            if (road != null) {
                if (road.getStatus().equals(Constants.STATUS_OK)) {
                    tvOrigin.setText(road.getOrigin_addresses().get(0));
                    tvDestination.setText(road.getDestination_addresses().get(0));
                    if (road.getRows().get(0).getElements().get(0).getStatus().equals(Constants.STATUS_OK)) {
                        distance = road.getRows().get(0).getElements().get(0).getDistance().getValue() / 1000;
                        tvDistance.setText(String.format("%skm", String.valueOf(distance)));
                        tvDuration.setText(road.getRows().get(0).getElements().get(0).getDuration().getText());
                    }
                }
            }
        }
    }

}
