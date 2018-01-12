package com.example.android.domotics;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Helpline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);
    }
    public void callMessage1(View view) {
        Intent startNewActivity = new Intent(getIntent().ACTION_DIAL);
        startNewActivity.setData(Uri.parse("tel:xxxxxxxxxx"));
        startActivity(startNewActivity);
    }

    public void callMessage2(View view) {
        Intent startNewActivity = new Intent(getIntent().ACTION_DIAL);
        startNewActivity.setData(Uri.parse("tel:xxxxxxxxxxx"));
        startActivity(startNewActivity);
    }

    public void mapMessage1(View view) {
        Intent startNewActivity = new Intent(getIntent().ACTION_VIEW, Uri.parse("google.navigation:qxxxxxxxxxxxxx"));
        startActivity(startNewActivity);
    }
}
