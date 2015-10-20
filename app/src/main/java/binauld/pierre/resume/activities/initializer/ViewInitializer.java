package binauld.pierre.resume.activities.initializer;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.MainActivityViewHolderVisitor;
import binauld.pierre.resume.view.impl.GeneralMainActivityViewHolder;
import binauld.pierre.resume.view.impl.NormalScreenMainActivityViewHolder;

/**
 * Initialize activity views.
 * Set up the toolbar as support action bar to the activity.
 * Set up the action bar drawer toggle.
 */
public class ViewInitializer implements MainActivityViewHolderVisitor {

    @Override
    public void visit(AppCompatActivity activity, GeneralMainActivityViewHolder viewHolder) {
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
