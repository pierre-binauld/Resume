package pierre.binauld.resume.activities.view.impl;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import butterknife.Bind;
import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityViewHolderVisitor;

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
