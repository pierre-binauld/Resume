package pierre.binauld.resume.toolbar;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

/**
 * Set up a Toolbar for an AppCompatActivity.
 */
public interface ToolbarInitializer {

    /**
     * Set up a Toolbar for an AppCompatActivity.
     * @param activity The activity where the toolbar has to be initialized.
     * @param toolbar The toolbar to initialized.
     */
    void initToolbar(AppCompatActivity activity, Toolbar toolbar);
}
