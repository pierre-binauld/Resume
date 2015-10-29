package binauld.pierre.resume.strategies.impl;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import binauld.pierre.resume.R;
import binauld.pierre.resume.adapters.EducationAdapter;
import binauld.pierre.resume.fragments.ListFragment;
import binauld.pierre.resume.listeners.BrowserListener;
import binauld.pierre.resume.listeners.LocationListener;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import butterknife.Bind;
import butterknife.ButterKnife;

public class GeneralMainActivityStrategy implements MainActivityStrategy {

    private AppCompatActivity activity;

    private Account account;

    private LocationListener locationListener;
    private BrowserListener  browserListener;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Bind(R.id.left_drawer)
    public NavigationView drawer;

    public GeneralMainActivityStrategy(AppCompatActivity activity, Account account) {
        this.activity = activity;
        this.account = account;
        ButterKnife.bind(this, activity);

        locationListener = new LocationListener(activity);
        browserListener  = new BrowserListener(activity);
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
        loadEducationFragment();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_item_education:
                loadEducationFragment();
                break;
            case R.id.nav_item_skills:
                loadSkillsFragment();
                break;
            case R.id.nav_item_tech_skills:
                loadTechSkillsFragment();
                break;
            case R.id.nav_item_experiences:
                loadExperiencesFragment();
                break;
            case R.id.nav_item_misc:
                loadMiscFragment();
                break;
            default:
                return false;
        }

        activity.setTitle(menuItem.getTitle());

        return true;
    }

    private void loadEducationFragment() {
        ListFragment educationFragment = new ListFragment();
        EducationAdapter adapter = new EducationAdapter(
                activity,
                account.getEducation(),
                locationListener,
                browserListener
        );
        educationFragment.setAdapter(adapter);
        switchFragment(educationFragment);
    }

    private void loadSkillsFragment() {

    }

    private void loadTechSkillsFragment() {
    }

    private void loadExperiencesFragment() {
    }

    private void loadMiscFragment() {
    }

    private void switchFragment(Fragment newFragment) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();

        transaction.replace(R.id.content_frame, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
