package com.example.mswang.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.example.mswang.myapplication.Utils.NetWorkUtil;


/**
 * Created by Ms.Wang on 2018/3/29.
 */

public class NetStateReceiver extends BroadcastReceiver {

    private static NetStateReceiver receiver;
    private IntentFilter  filter;
    private   static Context  mContext;

    private  NetStateReceiver(){}

    public  static  NetStateReceiver  getInstance(){
        mContext=MyApplication.getInstance();
        if(receiver==null){
            receiver=new NetStateReceiver();
        }
        return receiver;
    }


    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction()== ConnectivityManager.CONNECTIVITY_ACTION){
            int  netState= NetWorkUtil.getConnectionType(MyApplication.getInstance());
            NetStateObservable.getObservableInstance().notifyObserver(netState);
        }
    }


    public void registerReceiver() {
        filter=new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.Net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        mContext.registerReceiver(receiver,filter);
    }

    public  void unRegisterReceiver(){
        mContext.unregisterReceiver(receiver);
    }
}