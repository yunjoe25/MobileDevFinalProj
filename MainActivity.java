package com.kjdy.mobiledevfinalproject;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


import com.kjdy.mobiledevfinalproject.dialog.CircleDialog;
import com.kjdy.mobiledevfinalproject.dialog.RectangleDialog;
import com.kjdy.mobiledevfinalproject.drawing.RectangleDrawingView;
import com.kjdy.mobiledevfinalproject.drawing.SimpleDrawingView;
import com.kjdy.mobiledevfinalproject.fragments.CircleFragment;
import com.kjdy.mobiledevfinalproject.fragments.LineFragment;
import com.kjdy.mobiledevfinalproject.fragments.NoShapeFragment;
import com.kjdy.mobiledevfinalproject.fragments.OvalFragment;
import com.kjdy.mobiledevfinalproject.fragments.RectangleFragment;
import com.kjdy.mobiledevfinalproject.util.UtilTheme;

import butterknife.ButterKnife;

import static android.view.View.VISIBLE;

public class MainActivity extends BaseActivity {

//    @BindView(R.id.pb_play_loading) ProgressBar progressTheme;
    final int DEFAULT_THEME = 0;
    final int CUSTOM_THEME_ONE = 1;
    final int CUSTOM_THEME_TWO = 2;
    final int CUSTOM_THEM_THREE = 3;

    //ONE:      rectangle
    //TWO:      circle
    //THREE:    oval
    //FOUR:     line
    final int MENU_SELECT_ZERO = 0;
    final int MENU_SELECT_ONE = 1;
    final int MENU_SELECT_TWO = 2;
    final int MENU_SELECT_THREE = 3;
    final int MENU_SELECT_FOUR = 4;

    int menuOptionSet =0;

    public static Toolbar toolbar;
    public static int toolbarOption;
    public static FloatingActionButton fabMain,fabStat,fabEdit;

    Animation fabOpen,fabClose,fabClockwise,fabCounterClockwise;
    private DrawerLayout mDrawer;
    boolean fabIsOpen = false;

    //changing toolbar color after theme option is selected
    public void changeToolBarColor(int theme){
        switch(theme){
            case DEFAULT_THEME:
                toolbar.setBackgroundColor(Color.BLUE);
                fabMain.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                fabStat.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                fabEdit.setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                break;
            case CUSTOM_THEME_ONE:
                toolbar.setBackgroundColor(Color.RED);
                fabMain.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                fabStat.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                fabEdit.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                break;
            case CUSTOM_THEME_TWO:
                toolbar.setBackgroundColor(Color.BLACK);
                fabMain.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                fabStat.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                fabEdit.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));

                break;
            case CUSTOM_THEM_THREE:
                toolbar.setBackgroundColor(Color.DKGRAY);
                fabMain.setBackgroundTintList(ColorStateList.valueOf(Color.DKGRAY));
                fabStat.setBackgroundTintList(ColorStateList.valueOf(Color.DKGRAY));
                fabEdit.setBackgroundTintList(ColorStateList.valueOf(Color.DKGRAY));


            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        fabMain = (FloatingActionButton) findViewById(R.id.fab_main);
        fabStat = (FloatingActionButton) findViewById(R.id.fab_stat);
        fabEdit = (FloatingActionButton) findViewById(R.id.fab_edit);

        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        fabClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        fabCounterClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_counterclockwise);

        setSupportActionBar(toolbar);
        changeToolBarColor(toolbarOption);
        ButterKnife.bind(this);

        //floating action bar onClickListener
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(menuOptionSet) {
                    case MENU_SELECT_ONE:
                    case MENU_SELECT_TWO:
                    case MENU_SELECT_THREE:
                    case MENU_SELECT_FOUR:
                        if(fabIsOpen){
                            closeFab();
                        } else{
                            openFab();
                        }
                        break;
                    default:
                        break;
                }

            }
        });

        //floating action bar stat onClickListener
        fabStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch(menuOptionSet){
                   case MENU_SELECT_ONE:
                       closeFab();
                       final RectangleDialog rectDialog = new RectangleDialog(view.getContext(), new RectangleDialog.ICustomDialogEventListener() {
                           @Override
                           public void onClickListener() {
                           }
                       });
                       rectDialog.show();
                       break;
                   case MENU_SELECT_TWO:
                       closeFab();
                       final CircleDialog circleDialog = new CircleDialog(view.getContext(), new CircleDialog.ICustomDialogEventListener() {
                           @Override
                           public void onClickListener() {
                           }
                       });
                       circleDialog.show();
                       break;
                   case MENU_SELECT_THREE:
                       break;

                   case MENU_SELECT_FOUR:
                       break;
                   //default:   No-Shape
                   default:
                       break;
               }
            }
        });

        //floating action bar edit onClickListener
        fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(menuOptionSet){
                    case MENU_SELECT_ONE:
//                        RectangleDrawingView.setRectangleX(100,100);
                        break;
                    case MENU_SELECT_TWO:
                        break;
                    case MENU_SELECT_THREE:
                        break;
                    case MENU_SELECT_FOUR:
                        break;
                    //default:  No-Shape
                    default:
                        break;
                }
            }
        });

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, new NoShapeFragment()).commit();


        }


    }

    //closing FAB animations & fabIsOpen = false;
    public void closeFab(){
        fabStat.startAnimation(fabClose);
        fabEdit.startAnimation(fabClose);
        fabMain.startAnimation(fabCounterClockwise);
        fabStat.setClickable(false);
        fabEdit.setClickable(false);

        fabIsOpen = false;
    }
    //opening FAB animations & fabIsOpen = true;
    public void openFab(){
        fabStat.startAnimation(fabOpen);
        fabEdit.startAnimation(fabOpen);
        fabMain.startAnimation(fabClockwise);
        fabStat.setClickable(true);
        fabEdit.setClickable(true);

        fabIsOpen = true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else if(fabIsOpen){
            closeFab();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            showShortToast("\"About\" option has been clicked");

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("About");
            builder.setMessage(R.string.about_message);
            builder.setCancelable(true);

            AlertDialog dialog = builder.create();

            dialog.show();
            return true;

        } else if(id == R.id.action_change_theme){
            singleChoiceDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int choice=0;
    private void singleChoiceDialog() {
        final String[] items = { "Custom theme 1", "Custom theme 2", "Custom theme 3", "Custom theme 4" };
        AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.DayNightAlertDialogTheme);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Theme options");
        builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                choice = which;
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showShortToast((choice+1) + "");
                showShortToast(items[choice]);

                //changing theme based on singleItemChoice option
                switch (choice){
                    case DEFAULT_THEME:
                        confirmThemeChange(UtilTheme.THEME_DEFAULT);
                        break;
                    case CUSTOM_THEME_ONE:
                        confirmThemeChange(UtilTheme.THEME_TEST);
                        break;
                    case CUSTOM_THEME_TWO:
                        confirmThemeChange(UtilTheme.THEME_TEST_TWO);
                        break;
                    case CUSTOM_THEM_THREE:
                        confirmThemeChange(UtilTheme.THEME_TEST_THREE);
                        break;
                    default:
                        break;
                }

            }
        });
        builder.show();
    }

    //normal dialog
    public void confirmThemeChange(final int themeOption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setIcon(R.mipmap.ic_launcher);
        builder.setTitle("Please Confirm");
        builder.setMessage("Are you sure you want to change theme? " +
                "This will remove prior drawn objects.");


        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showShortToast("You clicked Yes");

                //assigning toolbar option
                toolbarOption = themeOption;
                UtilTheme.changeToTheme(MainActivity.this,themeOption);

                //changing the theme by relaunching the activity
                UtilTheme.onActivityCreateSetTheme(MainActivity.this);


            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showShortToast("You clicked No");
            }
        });

        builder.show();
    }


    NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            mDrawer.closeDrawer(GravityCompat.START);

            Fragment fragment = null;
            final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.nav_noshape:
                    fragment = new NoShapeFragment();
                    menuOptionSet = MENU_SELECT_ZERO;
                    break;
                case R.id.nav_rectangle:
                    fragment = new RectangleFragment();
                    menuOptionSet = MENU_SELECT_ONE;
                    break;
                case R.id.nav_circle:
                    fragment = new CircleFragment();
                    menuOptionSet = MENU_SELECT_TWO;
                    break;
                case R.id.nav_oval:
                    fragment = new OvalFragment();
                    menuOptionSet = MENU_SELECT_THREE;
                    break;
                case R.id.nav_line:
                    fragment = new LineFragment();
                    menuOptionSet = MENU_SELECT_FOUR;
                    break;

            }

            ft.replace(R.id.fragment, fragment).commit();
            return true;
        }
    };
}
