package com.teda.practiceempresarial.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.gson.JsonObject;
import com.teda.practiceempresarial.R;
import com.teda.practiceempresarial.model.Road;
import com.teda.practiceempresarial.presenter.MainActivityContract;
import com.teda.practiceempresarial.presenter.MainActivityPresenter;
import com.teda.practiceempresarial.util.Constants;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private TextInputEditText etOrigin;
    private TextInputEditText etDestination;
    private TextInputLayout tilOrigin;
    private TextInputLayout tilDestination;
    private Button btnCalculate;
    private MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etOrigin = findViewById(R.id.et_origin);
        etDestination = findViewById(R.id.et_destination);
        tilOrigin = findViewById(R.id.til_origin);
        tilDestination = findViewById(R.id.til_destination);
        btnCalculate = findViewById(R.id.btn_calculate);

        presenter = new MainActivityPresenter();
        presenter.setView(this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateFields()) {
                    presenter.calculateDistance(etOrigin.getText().toString(),
                            etDestination.getText().toString());
                }
            }
        });
    }

    @Override
    public void goToDetails(Road road) {
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra(Constants.EXTRAS_ROAD, road);
        startActivity(intent);
    }

    public boolean validateFields() {
        boolean validate = true;
        if (etOrigin.getText().toString().isEmpty()) {
            tilOrigin.setError(getString(R.string.msg_insert_origin));
            validate = false;
        } else {
            tilOrigin.setError(null);
        }
        if (etDestination.getText().toString().isEmpty()) {
            tilDestination.setError(getString(R.string.msg_insert_destination));
            validate = false;
        } else {
            tilDestination.setError(null);
        }

        return validate;
    }
}
