package com.example.lsh.clickerwaiting_onescreen;

import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.DrawableUtils;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb_HeatCapacity;
    ProgressBar pb_HeatProduction;
    Button bt_Heat;
    int capacityProgress = 0;
    int capacityMax = 10;
    int productionMax = 100;
    long productionTime =5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // setting progressbar
        pb_HeatCapacity = (ProgressBar) findViewById(R.id.pb_HeatCapacity);
        pb_HeatProduction = (ProgressBar) findViewById(R.id.pb_HeatProduction);
        pb_HeatCapacity.setMax(capacityMax);
        pb_HeatProduction.setMax(productionMax);
        bt_Heat = (Button) findViewById(R.id.bt_Heat);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void HeatClick(View v) {
        bt_Heat.setEnabled(false);
        new CountDownTimer(productionTime, 10) {
            int productionProgress = 0;

            public void onTick(long millisUntilFinished) {
                productionProgress = (int) ((productionTime - millisUntilFinished) * 100 / productionTime);
                pb_HeatProduction.setProgress(productionProgress);
            }

            public void onFinish() {
                productionProgress = 0;
                pb_HeatProduction.setProgress(productionProgress);
                if(capacityProgress < capacityMax)
                    capacityProgress++;
                pb_HeatCapacity.setProgress(capacityProgress, true);
                bt_Heat.setEnabled(true);
            }
        }.start();
    }



}
