package com.hasee.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hasee.coolweather.util.HttpUtil;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        if(prefs.getString("weather",null)!=null){
            Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
