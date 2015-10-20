package binauld.pierre.resume.strategies;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Define an interface for different strategies of a drawer fragment.
 * Strategy may vary because of different configurations.
 */
public interface DrawerStrategy {

    /**
     * The strategy used when fragment called its own onCreateView method.
     * @param inflater The LayoutInflater object that can be used to inflate any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's UI should be attached to. The fragment should not add the view itself, but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed from a previous saved state as given here.
     * @return Return the View for the fragment's UI, or null.

     */
    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);
}
