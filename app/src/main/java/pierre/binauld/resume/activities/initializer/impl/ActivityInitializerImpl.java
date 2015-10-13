package pierre.binauld.resume.activities.initializer.impl;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityInitializer;

/**
 * Initialize an activity.
 * Set up the toolbar as support action bar to the activity.
 * Set up the action bar drawer toggle.
 */
public class ActivityInitializerImpl implements ActivityInitializer {

    @Override
    public void initActivity(AppCompatActivity activity, Toolbar toolbar, DrawerLayout drawerLayout) {
        activity.setSupportActionBar(toolbar);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                activity,
                drawerLayout,
                toolbar,
                R.string.opened_drawer_content_desc,
                R.string.closed_drawer_content_desc);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
