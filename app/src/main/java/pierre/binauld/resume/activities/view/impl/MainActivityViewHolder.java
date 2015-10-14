package pierre.binauld.resume.activities.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import pierre.binauld.resume.R;
import pierre.binauld.resume.activities.initializer.ActivityViewHolderVisitor;
import pierre.binauld.resume.activities.view.ActivityViewHolder;

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
