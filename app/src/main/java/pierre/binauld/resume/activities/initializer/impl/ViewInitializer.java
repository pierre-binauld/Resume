package pierre.binauld.resume.activities.initializer.impl;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityViewHolderVisitor;
import pierre.binauld.resume.activities.view.impl.MainActivityViewHolder;
import pierre.binauld.resume.activities.view.impl.NormalScreenMainActivityViewHolder;

/**
 * Initialize activity views.
 * Set up the toolbar as support action bar to the activity.
 * Set up the action bar drawer toggle.
 */
public class ViewInitializer implements ActivityViewHolderVisitor {

    @Override
    public void visit(AppCompatActivity activity, MainActivityViewHolder viewHolder) {
        activity.setSupportActionBar(viewHolder.toolbar);
    }

    @Override
    public void visit(AppCompatActivity activity, NormalScreenMainActivityViewHolder viewHolder) {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                activity,
                viewHolder.drawerLayout,
                viewHolder.toolbar,
                R.string.opened_drawer_content_desc,
                R.string.closed_drawer_content_desc);

        viewHolder.drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}