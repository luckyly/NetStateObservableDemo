package com.example.mswang.myapplication;

import java.util.Observable;

/**
 * Created by Ms.Wang on 2018/4/18.
 */

public class NetStateObservable extends Observable {

    private  static  NetStateObservable  observable;

    private   NetStateObservable(){}

    public  static NetStateObservable  getObservableInstance(){
        if(observable==null){
            observable=new NetStateObservable();
        }
        return observable;
    }

    public  void  notifyObserver(int   netState){
        observable.setChanged();//必须调用
        observable.notifyObservers(netState);
    }
}