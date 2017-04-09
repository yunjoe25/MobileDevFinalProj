package com.kjdy.mobiledevfinalproject;

import android.app.Application;
import android.widget.Toast;

import com.kjdy.mobiledevfinalproject.util.UtilLog;

/**
 * Created by yunjo on 4/5/2017.
 */

public class AppConfig extends Application {
    //runs before any activity runs
    @Override
    public void onCreate() {
        super.onCreate();

        //Log option turned on
        UtilLog.setDebug(true);

        // toasting debug status
        if(UtilLog.getDebug()){
            Toast.makeText(this,"UtilLog ON",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this,"UtilLog OFF",Toast.LENGTH_SHORT).show();
        }

    }

}
