package com.georgeren.myjenkins;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvText = (TextView) findViewById(R.id.tv_test);
        tvText.setText("线上:"+BuildConfig.ONLINE+" 渠道:"+BuildConfig.CHANNEL);
    }
}
