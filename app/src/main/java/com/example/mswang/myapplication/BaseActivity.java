package com.example.mswang.myapplication;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.example.mswang.myapplication.Utils.NetWorkUtil;
import com.example.mswang.myapplication.Utils.ToastUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Ms.Wang on 2018/4/16.
 */

public class BaseActivity  extends Activity  implements Observer {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().addObserver(this);
        MyApplication.getInstance().registerReceiver();
    }


    @Override
    public void update(Observable o, Object arg) {
        ToastUtil.showShortToast(this,"BaseActivity");
        int  netState= (int) arg;

        switch (netState){
            case NetWorkUtil.NET_NO_CONNECTION:
                ToastUtil.showShortToast(getApplicationContext(),"无网络连接");
                break;
            case NetWorkUtil.NET_TYPE_2G:
                ToastUtil.showShortToast(getApplicationContext(),"2G网络");
                break;
            case NetWorkUtil.NET_TYPE_3G:
                ToastUtil.showShortToast(getApplicationContext(),"3G网络");
                break;
            case NetWorkUtil.NET_TYPE_4G:
                ToastUtil.showShortToast(getApplicationContext(),"4G网络");
                break;
            case NetWorkUtil.NET_TYPE_WIFI:
                ToastUtil.showShortToast(getApplicationContext(),"WIFI已连接");
                break;
            case NetWorkUtil.NET_TYPE_UNKNOWN:
                ToastUtil.showShortToast(getApplicationContext(),"未知的网络类型");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getInstance().removeObserver(this);
        MyApplication.getInstance().unRegisterReceiver();
    }
}