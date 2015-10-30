package binauld.pierre.resume.factories.impl;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import binauld.pierre.resume.factories.LayoutManagerFactory;

/**
 * Create a RecyclerView StaggeredGridLayoutManager with 2 column and vertical orientation.
 */
public class StaggeredGridLayoutManagerFactory implements LayoutManagerFactory {

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
    }
}
