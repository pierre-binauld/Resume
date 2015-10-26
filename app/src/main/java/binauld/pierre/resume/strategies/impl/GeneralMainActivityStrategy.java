package binauld.pierre.resume.strategies.impl;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import binauld.pierre.resume.R;
import binauld.pierre.resume.fragments.ListFragment;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import butterknife.Bind;
import butterknife.ButterKnife;

public class GeneralMainActivityStrategy implements MainActivityStrategy {

    private AppCompatActivity activity;

    private Account account;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Bind(R.id.left_drawer)
    public NavigationView drawer;

    public GeneralMainActivityStrategy(AppCompatActivity activity, Account account) {
        this.activity = activity;
        this.account = account;
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
        activity.setSupportActionBar(toolbar);

        drawer.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_item_education:
                onEducationClick(menuItem);
                break;
            case R.id.nav_item_skills:
                onSkillsClick(menuItem);
                break;
            case R.id.nav_item_tech_skills:
                onTechSkillsClick(menuItem);
                break;
            case R.id.nav_item_experiences:
                onExperiencesClick(menuItem);
                break;
            case R.id.nav_item_misc:
                onMiscClick(menuItem);
                break;
            default:
                return false;
        }

        return true;
    }

    public void onEducationClick(MenuItem item) {
        Log.d(this.getClass().toString(), "onEducationClick");

        Fragment newFragment = new ListFragment();
        switchFragment(newFragment);

    }

    public void onSkillsClick(MenuItem item) {
        Log.d(this.getClass().toString(), "onSkillsClick");
    }

    public void onTechSkillsClick(MenuItem item) {
        Log.d(this.getClass().toString(), "onTechSkillsClick");
    }

    public void onExperiencesClick(MenuItem item) {
        Log.d(this.getClass().toString(), "onExperiencesClick");
    }

    public void onMiscClick(MenuItem item) {
        Log.d(this.getClass().toString(), "onMiscClick");
    }

    public void switchFragment(Fragment newFragment) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();

        transaction.replace(R.id.content_frame, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
