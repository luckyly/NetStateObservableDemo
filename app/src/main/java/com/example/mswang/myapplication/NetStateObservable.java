package com.example.mswang.myapplication;

import java.util.Observable;

/**
 * Created by Ms.Wang on 2018/4/18.
 */

public class NetStateObservable extends Observable {

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}