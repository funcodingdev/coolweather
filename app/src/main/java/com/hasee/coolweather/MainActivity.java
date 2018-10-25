package com.hasee.coolweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hasee.coolweather.util.HttpUtil;

import org.litepal.LitePal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
