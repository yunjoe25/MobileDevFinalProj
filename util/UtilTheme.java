package com.kjdy.mobiledevfinalproject.util;

import com.kjdy.mobiledevfinalproject.R;

/**
 * Created by yunjo on 4/6/2017.
 */


import android.app.Activity;
import android.content.Intent;

public class UtilTheme {
    private static int sTheme;
    public final static int THEME_DEFAULT = 0;
    public final static int THEME_TEST = 1;
    public final static int THEME_TEST_TWO = 2;
    public final static int THEME_TEST_THREE = 3;

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            case THEME_DEFAULT:
                activity.setTheme(R.style.CustomThemeOne);
                break;
            case THEME_TEST:
                activity.setTheme(R.style.CustomThemeTwo);
                break;
            case THEME_TEST_TWO:
                activity.setTheme(R.style.CustomThemeThree);
                break;
            case THEME_TEST_THREE:
                activity.setTheme(R.style.CustomThemeFour);
            default:
                break;
        }
    }
    /**
     * Set the theme of the Activity, and restart it by creating a new Activity of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }
}
