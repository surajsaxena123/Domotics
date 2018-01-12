package com.example.android.domotics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_settings);
    }
    /*public void settingWifi(View view) {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName("com.android.settings", "com.android.settings.wifi.WifiSettings");
        startActivity(intent);*/
    public void wif(View view){
        Intent startNewActivity = new Intent(this,wifi.class);
        startActivity(startNewActivity);
    }
}
