package binauld.pierre.resume.activities.view.impl;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.R;
import binauld.pierre.resume.activities.initializer.ActivityViewHolderVisitor;
import butterknife.Bind;

/**
 * Hold views of main activity for normal screen.
 */
public class NormalScreenMainActivityViewHolder extends MainActivityViewHolder {

    @Bind(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @Override
    public void accept(AppCompatActivity activity, ActivityViewHolderVisitor activityViewHolderVisitor) {
        super.accept(activity, activityViewHolderVisitor);
        activityViewHolderVisitor.visit(activity, this);
    }
}
