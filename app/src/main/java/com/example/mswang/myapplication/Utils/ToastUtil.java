package com.example.mswang.myapplication.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ms.Wang on 2018/4/8.
 *避免重复提示
 */

public class ToastUtil {

    private static Toast toast=null;

    public  static  void   showShortToast(Context context, String  msg){
        if(toast==null){
            toast=Toast.makeText(context,msg,Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }

        toast.show();
    }

    public static   void   showLongToast(Context context, String  msg){
        if(toast==null){
            toast=Toast.makeText(context,msg,Toast.LENGTH_LONG);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }
}
