package binauld.pierre.resume.activities.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import binauld.pierre.resume.R;
import binauld.pierre.resume.activities.initializer.ActivityViewHolderVisitor;
import binauld.pierre.resume.activities.view.ActivityViewHolder;
import butterknife.Bind;

/**
 * Hold views of main activity.
 */
public class MainActivityViewHolder implements ActivityViewHolder {

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    public void accept(AppCompatActivity activity, ActivityViewHolderVisitor activityViewHolderVisitor) {
        activityViewHolderVisitor.visit(activity, this);
    }
}
