package binauld.pierre.resume.factories;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

/**
 * Define an interface for creating a RecyclerView layout manager.
 */
public interface LayoutManagerFactory {

    /**
     * Create a RecyclerView LayoutManager.
     * @param activity The activity for the LayoutManager.
     * @return The LayoutManager.
     */
    RecyclerView.LayoutManager getLayoutManager(Activity activity);
}
