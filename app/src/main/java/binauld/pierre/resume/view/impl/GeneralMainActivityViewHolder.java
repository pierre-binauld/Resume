package binauld.pierre.resume.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.MainActivityViewHolder;
import binauld.pierre.resume.view.MainActivityViewHolderVisitor;
import butterknife.Bind;

/**
 * Hold views of main activity.
 */
public class GeneralMainActivityViewHolder implements MainActivityViewHolder {

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    public void accept(AppCompatActivity activity, MainActivityViewHolderVisitor viewHolderVisitor) {
        viewHolderVisitor.visit(activity, this);
    }

}
