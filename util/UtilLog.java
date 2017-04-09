package com.kjdy.mobiledevfinalproject.util;

/**
 * Created by yunjo on 4/5/2017.
 */
import android.util.Log;

/**
 * Created by yunjo on 2/6/2017.
 */

public class UtilLog {
    //
    private static boolean Debug = false;

    public static void setDebug(boolean b){
        Debug = b;
    }

    public static boolean getDebug(){
        return Debug;
    }


    public static void logE(String key, String value){
        if(Debug){
            Log.e(key,value);
        }
    }

    public static void logI(String key, String value){
        if(Debug){
            Log.i(key,value);
        }
    }
    public static void logV(String key, String value){
        if(Debug){
            Log.v(key,value);
        }
    }
    public static void logW(String key, String value){
        if(Debug){
            Log.w(key,value);
        }
    }
    public static void logD(String key, String value){
        if(Debug){
            Log.d(key,value);
        }
    }
}

