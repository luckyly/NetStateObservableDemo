package com.example.mswang.myapplication;

import android.app.Application;
import android.content.IntentFilter;

import com.example.mswang.myapplication.Utils.ToastUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ms.Wang on 2018/4/16.
 */

public class MyApplication  extends Application {

    private   NetStateObservable observable;
    private   NetStateReceiver receiver;
    private   IntentFilter  filter;
    private  static  MyApplication  application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        observable=new NetStateObservable();
        receiver=new NetStateReceiver();
        registerReceiver();

    }

    public  static  MyApplication  getInstance(){
        return application;
    }

    public  void  addObserver(Observer  observer){
        observable.addObserver(observer);
    }

    public   void removeObserver(Observer  observer){
        observable.deleteObserver(observer);
    }

    public  void  notifyObserver(int   netState){
        observable.setChanged();//必须调用
        observable.notifyObservers(netState);
    }

    public void registerReceiver() {
        filter=new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        filter.addAction("android.Net.wifi.WIFI_STATE_CHANGED");
        filter.addAction("android.net.wifi.STATE_CHANGE");
        registerReceiver(receiver,filter);
    }

    public  void unRegisterReceiver(){
        unregisterReceiver(receiver);
    }
}