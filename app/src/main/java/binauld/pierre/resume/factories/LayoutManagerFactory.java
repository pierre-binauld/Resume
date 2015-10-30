package binauld.pierre.resume.factories;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;

public interface LayoutManagerFactory {

    RecyclerView.LayoutManager getLayoutManager(Activity activity);
}
