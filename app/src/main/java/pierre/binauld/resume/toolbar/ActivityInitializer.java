package pierre.binauld.resume.toolbar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Initialize an activity with setting up toolbar, drawer, etc.
 */
public interface ActivityInitializer {

    /**
     * Initialize an activity with setting up toolbar, drawer, etc.
     * @param activity The activity to initialized.
     * @param toolbar The toolbar to set up in the activity.
     * @param drawerLayout The drawer layout to set up in the activity.
     */
    void initActivity(AppCompatActivity activity, Toolbar toolbar, DrawerLayout drawerLayout);
}
