package binauld.pierre.resume.factories.impl;


import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import binauld.pierre.resume.factories.LayoutManagerFactory;

public class SmallItemLayoutManagerFactory implements LayoutManagerFactory {

    private int spanCount;

    public SmallItemLayoutManagerFactory(int spanCount) {
        this.spanCount = spanCount;
    }

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new GridLayoutManager(activity, spanCount);
    }
}
