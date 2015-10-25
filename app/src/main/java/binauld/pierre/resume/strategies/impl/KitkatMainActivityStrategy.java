package binauld.pierre.resume.strategies.impl;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import binauld.pierre.resume.R;
import binauld.pierre.resume.strategies.MainActivityStrategy;
public class KitkatMainActivityStrategy implements MainActivityStrategy {

    private MainActivityStrategy strategy;

    private AppCompatActivity activity;

    public KitkatMainActivityStrategy(MainActivityStrategy strategy) {
        this.strategy = strategy;
        this.activity = strategy.getActivity();
    }

    @Override
    public AppCompatActivity getActivity() {
        return activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        strategy.onCreate(savedInstanceState);

        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(ContextCompat.getColor(activity, R.color.status_bar_color));
    }
}
