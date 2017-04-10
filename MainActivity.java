package com.kjdy.mobiledevfinalproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


import com.kjdy.mobiledevfinalproject.drawing.SimpleDrawingView;
import com.kjdy.mobiledevfinalproject.fragments.CircleFragment;
import com.kjdy.mobiledevfinalproject.fragments.LineFragment;
import com.kjdy.mobiledevfinalproject.fragments.NoShapeFragment;
import com.kjdy.mobiledevfinalproject.fragments.OvalFragment;
import com.kjdy.mobiledevfinalproject.fragments.RectangleFragment;
import com.kjdy.mobiledevfinalproject.util.UtilTheme;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

//    @BindView(R.id.pb_play_loading) ProgressBar progressTheme;
    final int DEFAULT_THEME = 0;
    final int CUSTOM_THEME_ONE = 1;
    final int CUSTOM_THEME_TWO = 2;
    final int CUSTOM_THEM_THREE = 3;

    public static Toolbar toolbar;
    public static int toolbarOption;
    public static FloatingActionButton fab;
    public static SimpleDrawingView sView;
    private DrawerLayout mDrawer;

    //changing toolbar color after theme option is selected
    public void changeToolBarColor(int theme){
        switch(theme){
            case DEFAULT_THEME:
//                toolbar.setBackgroundColor(Color.);
                break;
            case CUSTOM_THEME_ONE:
                toolbar.setBackgroundColor(Color.RED);
                fab.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                break;
            case CUSTOM_THEME_TWO:
                toolbar.setBackgroundColor(Color.BLACK);
                fab.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                break;
            case CUSTOM_THEM_THREE:
                toolbar.setBackgroundColor(Color.DKGRAY);
                fab.setBackgroundTintList(ColorStateList.valueOf(Color.DKGRAY));
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
//        sView = (SimpleDrawingView) findViewById(R.id.drawView);
        setSupportActionBar(toolbar);
        changeToolBarColor(toolbarOption);
        ButterKnife.bind(this);



        //floating action bar onClickListener
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
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
                    break;
                case R.id.nav_rectangle:
                    fragment = new RectangleFragment();
                    break;
                case R.id.nav_circle:
                    fragment = new CircleFragment();
                    break;
                case R.id.nav_oval:
                    fragment = new OvalFragment();
                    break;
                case R.id.nav_line:
                    fragment = new LineFragment();
                    break;

            }

            ft.replace(R.id.fragment, fragment).commit();
            return true;
        }
    };
}
