package binauld.pierre.resume.view.impl;


import android.support.v7.widget.RecyclerView;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.DrawerViewHolder;
import binauld.pierre.resume.view.DrawerViewHolderVisitor;
import butterknife.Bind;

public class GeneralDrawerViewHolder implements DrawerViewHolder {

    @Bind(R.id.drawer_list)
    public RecyclerView recyclerView;

    @Override
    public void accept(DrawerViewHolderVisitor viewHolderVisitor) {
        viewHolderVisitor.visit(this);
    }
}
