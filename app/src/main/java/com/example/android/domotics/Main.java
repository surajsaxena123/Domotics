

package com.example.android.domotics;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Main extends AppCompatActivity {


    boolean IS_DRAGONBOARD = false;

    Switch  swPin31, swPin32, swPin33;

    GpioProcessor.Gpio pin;
    Gpio gpio;
    private ValueEventListener mGpioListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        checkWifi();


        swPin31 = (Switch) findViewById(R.id.sw_pin_31);
        swPin32 = (Switch) findViewById(R.id.sw_pin_32);
        swPin33 = (Switch) findViewById(R.id.sw_pin_33);


        Firebase.setAndroidContext(this);
        final Firebase user1Ref = new Firebase("https://dommoticsark.firebaseio.com/");

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd,MMMM,yyyy hh,mm,a");
        String now = sdf.format(c.getTime());
        user1Ref.child("LastAccess").setValue(now);


        gpio = new Gpio(0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0);
        user1Ref.child("gpio").setValue(gpio);

        // Common code for both, only difference for Dragonboard to perform physical change on pins
        mGpioListener = user1Ref.child("gpio").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                AlertDialog alertDialog = new AlertDialog.Builder(Main.this).create();
                alertDialog.setTitle("Home Update");

                gpio = snapshot.getValue(Gpio.class);

                // updateUI

                swPin31.setChecked((gpio.getPin31() != 0));
                swPin32.setChecked((gpio.getPin32() != 0));
                swPin33.setChecked((gpio.getPin33() != 0));


                alertDialog.setMessage(Integer.toString(gpio.getPin23()) + " " + Integer.toString(gpio.getPin24()) + " " + Integer.toString(gpio.getPin25()) + " " + Integer.toString(gpio.getPin26()) + " " +
                        Integer.toString(gpio.getPin27()) + " " + Integer.toString(gpio.getPin28()) + " " + Integer.toString(gpio.getPin29()) + " " +
                        Integer.toString(gpio.getPin30()) + " " + Integer.toString(gpio.getPin31()) + " " + Integer.toString(gpio.getPin32()) + " " +
                        Integer.toString(gpio.getPin33()) + " " + Integer.toString(gpio.getPin34()));
                alertDialog.show();

                if (IS_DRAGONBOARD)
                    setAllPins(gpio);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        swPin31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gpio.getPin31() == GpioProcessor.Gpio.HIGH) {
                    user1Ref.child("gpio").child("pin31").setValue(GpioProcessor.Gpio.LOW);
                } else {
                    user1Ref.child("gpio").child("pin31").setValue(GpioProcessor.Gpio.HIGH);
                }
            }
        });

        swPin32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gpio.getPin32() == GpioProcessor.Gpio.HIGH) {
                    user1Ref.child("gpio").child("pin32").setValue(GpioProcessor.Gpio.LOW);
                } else {
                    user1Ref.child("gpio").child("pin32").setValue(GpioProcessor.Gpio.HIGH);
                }
            }
        });

        swPin33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gpio.getPin33() == GpioProcessor.Gpio.HIGH) {
                    user1Ref.child("gpio").child("pin33").setValue(GpioProcessor.Gpio.LOW);
                } else {
                    user1Ref.child("gpio").child("pin33").setValue(GpioProcessor.Gpio.HIGH);
                }
            }
        });



    }

    public void setAllPins(Gpio gpio) {

        GpioProcessor gpioProcessor = new GpioProcessor();

        GpioProcessor.Gpio led = gpioProcessor.getPin23();
        led.out();
        if (gpio.getPin23() == GpioProcessor.Gpio.HIGH) led.high();
        else led.low();


    led=gpioProcessor.getPin24();
    led.out();
    if(gpio.getPin24()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin25();
    led.out();
    if(gpio.getPin25()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin26();
    led.out();
    if(gpio.getPin26()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin27();
    led.out();
    if(gpio.getPin27()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin28();
    led.out();
    if(gpio.getPin28()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin29();
    led.out();
    if(gpio.getPin29()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin30();
    led.out();
    if(gpio.getPin30()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin31();
    led.out();
    if(gpio.getPin31()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin32();
    led.out();
    if(gpio.getPin32()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin33();
    led.out();
    if(gpio.getPin33()==GpioProcessor.Gpio.HIGH)led.high();else led.low();

    led=gpioProcessor.getPin34();
    led.out();
    if(gpio.getPin34()==GpioProcessor.Gpio.HIGH)led.high();else led.low();
}

    /**
     * Name: connectWifiNetwork
     * Description: Opens the setting page to enable the user to turn
     *              Wifi on and connect to a specific network
     *
     * @param
     *
     *
     */
    public void checkWifi() {
        WifiManager wifiManager =
                (WifiManager) getSystemService(Context.WIFI_SERVICE);
        if (wifiManager.isWifiEnabled()) {

            Toast.makeText(Main.this, "Wifi is enabled", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Main.this, "Wifi is DISABLED", Toast.LENGTH_LONG).show();

            Intent wifiIntent = new Intent(Settings.ACTION_WIFI_SETTINGS);
            startActivityForResult(wifiIntent, 0);
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        // Unregister the listener
        //user1Ref.child("gpio").removeEventListener(mGpioListener);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}