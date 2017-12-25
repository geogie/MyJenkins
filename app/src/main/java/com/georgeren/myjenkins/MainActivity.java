package com.georgeren.myjenkins;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvText = (TextView) findViewById(R.id.tv_test);


        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager()
                    .getApplicationInfo(getPackageName(),
                            PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String msg = "";
        if (appInfo != null) {
            Bundle metaData = appInfo.metaData;
            if (metaData != null) {
                int channel = metaData.getInt("channel");
                Log.d("测试", "msg1:" + channel);
                String channel2 = metaData.getString("channel2");
                Log.d("测试", "msg1:" + channel2);
                msg = metaData.getString("MTA_APPKEY");
                Log.d("测试", "msg2:" + msg);
                msg = metaData.getString("JPUSH_APPKEY");
                Log.d("测试", "msg2:" + msg);

                String string = "Bundle{";
                for (String key : metaData.keySet()) {
                    string += " " + key + " => " + metaData.get(key) + ";";
                }
                string += " }Bundle";

                Log.d("测试","遍历："+string);
            }
        }



        try {
            PackageManager pm = getPackageManager();
            PackageInfo pinfo = pm.getPackageInfo(getPackageName(), PackageManager.GET_CONFIGURATIONS);
            int versionCode = pinfo.versionCode;
            String versionName = pinfo.versionName;
            Log.d("测试","版本versionCode："+versionCode+" versionName；"+versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        tvText.setText("线上:" + BuildConfig.ONLINE + " 渠道:" + BuildConfig.CHANNEL + " meta:" + msg);
    }
}
