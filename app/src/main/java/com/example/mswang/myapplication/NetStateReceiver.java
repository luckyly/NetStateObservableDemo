package com.example.mswang.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.example.mswang.myapplication.Utils.NetWorkUtil;
import com.example.mswang.myapplication.Utils.ToastUtil;


/**
 * Created by Ms.Wang on 2018/3/29.
 */

public class NetStateReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction()== ConnectivityManager.CONNECTIVITY_ACTION){
            int  netState= NetWorkUtil.getConnectionType(MyApplication.getInstance());
            MyApplication.getInstance().notifyObserver(netState);
        }
    }
}