//package com.kjdy.mobiledevfinalproject.main_option;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//
//import com.kjdy.mobiledevfinalproject.BaseActivity;
//import com.kjdy.mobiledevfinalproject.R;
//
//import butterknife.ButterKnife;
//
///**
// * Created by yunjo on 4/5/2017.
// */
//
//public class MainMenuThemeActivity extends BaseActivity {
//
//    public final static int THEME_HOLO_LIGHT = 0;
//    public final static int THEME_BLACK = 1;
//    int position;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }
//
//    //single choice dialog
//    int choice=0;
//    private void singleChoiceDialog() {
//        final String[] items = {"item1","item2","item3","item4"};
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setIcon(R.mipmap.ic_launcher);
//        builder.setTitle("singleChoiceDialog");
//        builder.setSingleChoiceItems(items,choice, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                choice = which;
//
//            }
//        });
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                showShortToast("You clicked"+ choice);
//            }
//        });
//        builder.show();
//    }
//}
