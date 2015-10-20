package binauld.pierre.resume.view;

import binauld.pierre.resume.view.impl.GeneralDrawerViewHolder;

public interface DrawerViewHolderVisitor {

    void visit(GeneralDrawerViewHolder viewHolder);
}
