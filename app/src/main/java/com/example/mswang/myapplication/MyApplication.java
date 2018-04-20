package com.example.mswang.myapplication;

import android.app.Application;

/**
 * Created by Ms.Wang on 2018/4/16.
 */

public class MyApplication  extends Application {

    /**
     * 提供一个实例，避免使用注入Context，降低耦合度
     */
    private  static  MyApplication  application;

    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }

    public  static  MyApplication  getInstance(){
        return application;
    }

}