package com.example.storescontrol.view;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.example.storescontrol.service.DemoIntentService;
import com.example.storescontrol.service.DemoPushService;
import com.igexin.sdk.PushManager;
import com.tencent.bugly.Bugly;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BaseApplication extends Application {

    private static DemoHandler handler;
    public static StringBuilder payloadData = new StringBuilder();
    public static LoginActivity demoActivity;
    @Override
    public void onCreate() {
        super.onCreate();

         // 初始化Bugly
        Bugly.init(getApplicationContext(), "8a29361815", false);
        if (handler == null) {
            handler = new DemoHandler();
        }
        PushManager.getInstance().initialize(getApplicationContext(), DemoPushService.class);
        PushManager.getInstance().registerPushIntentService(this.getApplicationContext(), DemoIntentService.class);

    }


    public static void sendMessage(Message msg) {
        handler.sendMessage(msg);
    }

    public static class DemoHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            Log.i("message",msg.obj.toString());
            switch (msg.what) {
                case 0:
                    payloadData.append((String) msg.obj);
                    payloadData.append("\n");
                    if (demoActivity != null) {

//                        if (GetuiSdkDemoActivity.tLogView != null) {
//                            GetuiSdkDemoActivity.tLogView.append(msg.obj + "\n");
//                        }
                    }

                    break;

                case 1:
                    if (demoActivity != null) {
//                        if (GetuiSdkDemoActivity.tLogView != null) {
//                            GetuiSdkDemoActivity.tView.setText((String) msg.obj);
//                        }
                    }
                    break;
            }
        }
    }

}
