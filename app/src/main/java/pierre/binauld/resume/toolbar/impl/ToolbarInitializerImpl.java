package pierre.binauld.resume.toolbar.impl;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import pierre.binauld.resume.toolbar.ToolbarInitializer;

/**
 * Set up a Toolbar for an AppCompatActivity.
 * Just set up the toolbar as support action bar to the activity.
 */
public class ToolbarInitializerImpl implements ToolbarInitializer {

    @Override
    public void initToolbar(AppCompatActivity activity, Toolbar toolbar) {
        activity.setSupportActionBar(toolbar);
    }
}
