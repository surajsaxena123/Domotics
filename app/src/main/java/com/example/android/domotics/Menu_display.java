package com.example.android.domotics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Menu_display extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_display);
    }
    public void sendMessage1(View view){
        Intent startNewActivity = new Intent(this,Main.class);
        startActivity(startNewActivity);
    }
    public void sendMessage2(View view){
        Intent startNewActivity = new Intent(this,Main_settings.class);
        startActivity(startNewActivity);
    }
    public void sendMessage3(View view) {
        Intent startNewActivity = new Intent(this, Helpline.class);
        startActivity(startNewActivity);
    }
}
