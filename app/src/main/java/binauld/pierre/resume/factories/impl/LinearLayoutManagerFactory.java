package binauld.pierre.resume.factories.impl;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import binauld.pierre.resume.factories.LayoutManagerFactory;

public class LinearLayoutManagerFactory implements LayoutManagerFactory {

    @Override
    public RecyclerView.LayoutManager getLayoutManager(Activity activity) {
        return new LinearLayoutManager(activity);
    }
}
