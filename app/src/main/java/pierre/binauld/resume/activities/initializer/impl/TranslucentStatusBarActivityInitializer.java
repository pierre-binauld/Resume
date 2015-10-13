package pierre.binauld.resume.activities.initializer.impl;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityInitializer;


/**
 * Initialize an activity.
 * Set up a top padding to the toolbar and make the status bar translucent.
 */
public class TranslucentStatusBarActivityInitializer implements ActivityInitializer {

    private ActivityInitializer activityInitializer;

    /**
     * Default constructor.
     * Decor another ActivityInitializer.
     * @param activityInitializer The other ActivityInitializer.
     */
    public TranslucentStatusBarActivityInitializer(ActivityInitializer activityInitializer) {
        this.activityInitializer = activityInitializer;
    }

    @Override
    public void initActivity(AppCompatActivity activity, Toolbar toolbar, DrawerLayout drawerLayout) {

        activityInitializer.initActivity(activity, toolbar, drawerLayout);

        toolbar.setPadding(0, getStatusBarHeight(activity), 0, 0);

        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(activity.getResources().getColor(R.color.status_bar_color));
    }

    /**
     * A method to find height of the status bar
     * @param activity The activity where the status bar came from.
     * @return The height of the status bar.
     */
    private int getStatusBarHeight(AppCompatActivity activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
