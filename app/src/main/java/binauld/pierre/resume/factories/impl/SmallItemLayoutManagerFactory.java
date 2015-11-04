package binauld.pierre.resume.factories.impl;


import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;

public class SmallItemLayoutManagerFactory {

    private int spanCount;

    public SmallItemLayoutManagerFactory(int spanCount) {
        this.spanCount = spanCount;
    }

    public GridLayoutManager getLayoutManager(Activity activity, GridLayoutManager.SpanSizeLookup spanSizeLookup) {
        GridLayoutManager layoutManager = new GridLayoutManager(activity, spanCount);
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        return layoutManager;
    }
}
