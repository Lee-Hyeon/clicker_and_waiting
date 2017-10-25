package com.example.lsh.clickerwaiting_onescreen;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb_HeatCapacity;
    ProgressBar pb_HeatProduction;
    Button bt_Heat;
    int capacityProgress = 0;
    int capacityMax = 10;
    int productionMax = 100;
    long productionTime =5000;

    ItemProperty Heat;
    ItemProperty Tank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // setting progressbar


        Heat = new ItemProperty();
        Tank = new ItemProperty();

        item_init(Heat, (ProgressBar) findViewById(R.id.pb_HeatCapacity),
                (ProgressBar) findViewById(R.id.pb_HeatProduction),
                (Button) findViewById(R.id.bt_Heat));
        item_init(Tank, (ProgressBar) findViewById(R.id.pb_TanksCapacity),
                (ProgressBar) findViewById(R.id.pb_TanksProduction),
                (Button) findViewById(R.id.bt_Tanks));
    }

    public void item_init(ItemProperty item, ProgressBar pb_cap, ProgressBar pb_prod, Button bt){
        item.pb_ItemCapacity = pb_cap;
        item.pb_ItemProduction = pb_prod;
        item.pb_ItemCapacity.setMax(item.capacityMax);
        item.pb_ItemProduction.setMax(item.productionMax);
        item.bt_Item = bt;
    }




}

class ItemProperty {
    ProgressBar pb_ItemCapacity;
    ProgressBar pb_ItemProduction;
    Button bt_Item;
    int capacityProgress = 0;
    int capacityMax = 10;
    int productionMax = 100;
    long productionTime =5000;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void itemClick(View v) {
        bt_Item.setEnabled(false);
        new CountDownTimer(productionTime, 10) {
            int productionProgress = 0;

            public void onTick(long millisUntilFinished) {
                productionProgress = (int) ((productionTime - millisUntilFinished) * 100 / productionTime);
                pb_ItemProduction.setProgress(productionProgress);
            }

            public void onFinish() {
                productionProgress = 0;
                pb_ItemProduction.setProgress(productionProgress);
                if (capacityProgress < capacityMax)
                    capacityProgress++;
                pb_ItemCapacity.setProgress(capacityProgress, true);
                bt_Item.setEnabled(true);
            }
        }.start();
    }
}