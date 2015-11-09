package binauld.pierre.resume.strategies.impl;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import javax.inject.Inject;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;

/**
 * The kitkat strategy for the main activity.
 * His role is to use the tint manager used when Kitkat.
 * This strategy is a decorator for other strategy.
 */
public class KitkatMainActivityStrategy implements MainActivityStrategy {

    private MainActivityStrategy strategy;

    protected AppCompatActivity activity;

    public KitkatMainActivityStrategy(AppCompatActivity activity, MainActivityStrategy strategy) {
        this.activity = activity;
        this.strategy = strategy;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        strategy.onCreate(savedInstanceState);

        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(ContextCompat.getColor(activity, R.color.status_bar_color));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        strategy.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onBackPressed() {
        return strategy.onBackPressed();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return strategy.onNavigationItemSelected(menuItem);
    }
}
