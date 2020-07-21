package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Date;

/**
 * ============================================================================================================
 * File Name：samService
 * Description：Service Class
 * Author： kc.fang
 * Created Date： 21,July,2020
 * =============================================================================================================
 */
public class samService extends Service {
    //宣告自定義的service class 的時候，要去AndroidManifest.xml註冊
    //在Application 標籤裡面加上 service class

    private static final String TAG ="samLog";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private Handler handler1 = new Handler();
    private Runnable showTime = new Runnable() {
        @Override
        public void run() {
            Log.i("myLog", new Date().toString());
            handler1.postDelayed(this, 1*1000);
        }
    };

    @Override
    public void onCreate() {
        Log.i(TAG, "Enter onCreate()");
        super.onCreate();
        Log.i(TAG, "Leave onCreate()");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Enter onStartCommand()");
        handler1.post(showTime); //開啟此Service便執行show Time
        return Service.START_STICKY; //一個return值，如果這個Service被異常終止，將嘗試重新執行此Service。

    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Enter onDestroy()");
        super.onDestroy();
        handler1.removeCallbacks(showTime);
        Log.i(TAG, "Leave onDestroy()");

    }
}
