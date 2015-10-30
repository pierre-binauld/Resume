package binauld.pierre.resume.factories.impl;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import binauld.pierre.resume.factories.LayoutManagerFactory;

public class StaggeredGridLayoutManagerFactory implements LayoutManagerFactory {

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }
}
