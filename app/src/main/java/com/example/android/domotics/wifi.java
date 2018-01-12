package com.example.android.domotics;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
public class wifi extends AppCompatActivity {
    Button varBtnOn, varBtnOff;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_wifi);
        varBtnOn = (Button) findViewById(R.id.btnON);
        varBtnOn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(true);
                Toast.makeText(getApplicationContext(), "Wifi is On", Toast.LENGTH_SHORT).show();
            }
        });
        varBtnOff = (Button) findViewById(R.id.btnOFF);
        varBtnOff.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                wifi.setWifiEnabled(false);
                Toast.makeText(getApplicationContext(), "Wifi is off", Toast.LENGTH_SHORT).show();

            }
        });
    }
}





