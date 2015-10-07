package pierre.binauld.resume.toolbar.impl;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import pierre.binauld.resume.R;
import pierre.binauld.resume.toolbar.ToolbarInitializer;


/**
 * Set up a Toolbar for an AppCompatActivity with translucent status bar.
 * Set up a top padding and make the status bar translucent.
 */
public class TranslucentToolbarInitializer implements ToolbarInitializer {

    private ToolbarInitializer toolbarInitializer;

    /**
     * Default constructor.
     * Decor a other ToolbarInitializer.
     * @param toolbarInitializer The other ToolbarInitializer.
     */
    public TranslucentToolbarInitializer(ToolbarInitializer toolbarInitializer) {
        this.toolbarInitializer = toolbarInitializer;
    }

    @Override
    public void initToolbar(AppCompatActivity activity, Toolbar toolbar) {

        toolbarInitializer.initToolbar(activity, toolbar);

        toolbar.setPadding(0, getStatusBarHeight(activity), 0, 0);

        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(activity.getResources().getColor(R.color.status_bar_color));
    }


    /**
     * A method to find height of the status bar
     * @param activity The activity where the status bar come from.
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
