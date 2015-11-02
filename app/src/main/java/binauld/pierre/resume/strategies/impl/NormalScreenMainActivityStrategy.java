package binauld.pierre.resume.strategies.impl;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.view.transformations.CircleTransformation;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * The normal screen strategy for the main activity.
 * His role is to initialize the drawer layout and manage it.
 * This strategy is a decorator for other strategy.
 */
public class NormalScreenMainActivityStrategy implements MainActivityStrategy {

    private MainActivityStrategy strategy;

    private AppCompatActivity activity;

    private Account account;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Bind(R.id.drawer_layout)
    public DrawerLayout drawerLayout;

    @Bind(R.id.left_drawer)
    public NavigationView drawer;

    @Bind(R.id.drawer_header_picture)
    public ImageView headerPictureView;

    @Bind(R.id.drawer_header_background)
    public ImageView headerBackgroundView;

    @Bind(R.id.drawer_header_subtitle_fullname)
    public TextView fullNameView;

    @Bind(R.id.drawer_header_subtitle_email)
    public TextView emailView;

    public NormalScreenMainActivityStrategy(MainActivityStrategy strategy) {
        this.strategy = strategy;
        this.activity = strategy.getActivity();
        this.account = strategy.getAccount();
        ButterKnife.bind(this, activity);
    }

    @Override
    public AppCompatActivity getActivity() {
        return activity;
    }

    @Override
    public Account getAccount() {
        return account;
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

        Picasso
                .with(activity)
                .load(account.getPictureAccount())
                .transform(new CircleTransformation())
                .resizeDimen(R.dimen.drawer_header_picture, R.dimen.drawer_header_picture)
                .centerCrop()
                .into(headerPictureView);

        Picasso
                .with(activity)
                .load(account.getPicturePanorama())
                .into(headerBackgroundView);

        fullNameView.setText(account.getFullName());
        emailView.setText(account.getEmail());

        drawer.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        strategy.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        if (strategy.onNavigationItemSelected(menuItem)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        } else {
            return false;
        }
    }
}
