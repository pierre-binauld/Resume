package binauld.pierre.resume.view.impl;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.MainActivityViewHolderVisitor;
import butterknife.Bind;

/**
 * Hold views of main activity for normal screen.
 */
public class NormalScreenMainActivityViewHolder extends GeneralMainActivityViewHolder {

    @Bind(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @Override
    public void accept(AppCompatActivity activity, MainActivityViewHolderVisitor viewHolderVisitor) {
        super.accept(activity, viewHolderVisitor);
        viewHolderVisitor.visit(activity, this);
    }
}
