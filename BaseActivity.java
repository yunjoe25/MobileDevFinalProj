package com.kjdy.mobiledevfinalproject;

/**
 * Created by yunjo on 4/5/2017.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    public void toActivity(Class name){
        Intent intent = new Intent(this, name);
        startActivity(intent);
    }

    public void showLongToast(String content){
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }

    public void showShortToast(String content){
        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }
}


