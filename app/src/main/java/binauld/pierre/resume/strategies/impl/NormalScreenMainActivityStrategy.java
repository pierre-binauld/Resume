package binauld.pierre.resume.strategies.impl;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import binauld.pierre.resume.R;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import butterknife.Bind;
import butterknife.ButterKnife;

public class NormalScreenMainActivityStrategy implements MainActivityStrategy {

    private MainActivityStrategy strategy;

    private AppCompatActivity activity;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Bind(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    public NormalScreenMainActivityStrategy(MainActivityStrategy strategy) {
        this.strategy = strategy;
        this.activity = strategy.getActivity();
        ButterKnife.bind(this, activity);
    }

    @Override
    public AppCompatActivity getActivity() {
        return activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        strategy.onCreate(savedInstanceState);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(
                activity,
                drawerLayout,
                toolbar,
                R.string.opened_drawer_content_desc,
                R.string.closed_drawer_content_desc);

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }
}
