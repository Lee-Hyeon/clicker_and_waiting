package com.example.lsh.clickerwaiting_onescreen;

import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb_HeatCapacity;
    private ProgressBar pb_HeatProduction;
    private Button bt_Heat;
    private int capacityProgress = 0;
    private int capacityMax = 10;
    private int productionProgress = 0;
    private int productionMax = 10;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // setting progressbar
        pb_HeatCapacity = (ProgressBar) findViewById(R.id.pb_HeatCapacity);
        pb_HeatProduction = (ProgressBar) findViewById(R.id.pb_HeatProduction);
        pb_HeatCapacity.setMax(capacityMax);
        pb_HeatCapacity.setProgress(capacityProgress);
        pb_HeatProduction.setMax(productionMax);
        pb_HeatProduction.setProgress(productionProgress);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void heatClick(View v) {

        if(capacityProgress < capacityMax)
            capacityProgress++;
        pb_HeatCapacity.setProgress(capacityProgress, true);
    }
}
