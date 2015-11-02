package binauld.pierre.resume.strategies;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.model.Account;

/**
 * Define a strategy for the main activity.
 * His role is to manage views depending of the configuration through the activity lifecycle.
 */
public interface MainActivityStrategy extends NavigationView.OnNavigationItemSelectedListener {

    /**
     * Get the activity of the strategy.
     * @return The activity.
     */
    AppCompatActivity getActivity();

    /**
     * Get the user account.
     * @return The user account.
     */
    Account getAccount();

    /**
     * Manage views during the onCreate method.
     * @param savedInstanceState The savedInstanceState of the activity onCreate method.
     */
    void onCreate(Bundle savedInstanceState);

    void onSaveInstanceState(Bundle savedInstanceState);

    void onBackPressed();
}
