package binauld.pierre.resume.view.visitor;

import android.support.v7.widget.RecyclerView;

import binauld.pierre.resume.view.DrawerViewHolderVisitor;
import binauld.pierre.resume.view.impl.GeneralDrawerViewHolder;

public class DrawerInitializer implements DrawerViewHolderVisitor {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public DrawerInitializer(RecyclerView.LayoutManager layoutManager, RecyclerView.Adapter adapter) {
        this.layoutManager = layoutManager;
        this.adapter = adapter;
    }

    @Override
    public void visit(GeneralDrawerViewHolder viewHolder) {

        viewHolder.recyclerView.setHasFixedSize(true);
        viewHolder.recyclerView.setLayoutManager(layoutManager);
        viewHolder.recyclerView.setAdapter(adapter);
    }
}
