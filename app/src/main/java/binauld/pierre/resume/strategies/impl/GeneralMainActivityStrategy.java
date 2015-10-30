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

/**
 * The general strategy for the main activity.
 * His role is to set the toolbar and manage fragments.
 */
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
        switchToEducationFragment();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.nav_item_education:
                switchToEducationFragment();
                break;
            case R.id.nav_item_skills:
                switchToSkillsFragment();
                break;
            case R.id.nav_item_tech_skills:
                switchToTechSkillsFragment();
                break;
            case R.id.nav_item_experiences:
                switchToExperiencesFragment();
                break;
            case R.id.nav_item_misc:
                switchToMiscFragment();
                break;
            default:
                return false;
        }

        activity.setTitle(menuItem.getTitle());

        return true;
    }

    /**
     * Switch to the education fragment.
     */
    private void switchToEducationFragment() {
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

    /**
     * Switch to the skills fragment.
     */
    private void switchToSkillsFragment() {
        ListFragment educationFragment = new ListFragment();
        switchFragment(educationFragment);

    }

    /**
     * Switch to the tech skills fragment.
     */
    private void switchToTechSkillsFragment() {
        ListFragment educationFragment = new ListFragment();
        switchFragment(educationFragment);
    }


    /**
     * Switch to the experiences fragment.
     */
    private void switchToExperiencesFragment() {
        ListFragment educationFragment = new ListFragment();
        switchFragment(educationFragment);
    }


    /**
     * Switch to the miscellaneous fragment.
     */
    private void switchToMiscFragment() {
        ListFragment educationFragment = new ListFragment();
        switchFragment(educationFragment);
    }

    /**
     * Switch to another fragment.
     * @param newFragment The fragment to switch on.
     */
    private void switchFragment(Fragment newFragment) {
        FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();

        transaction.replace(R.id.content_frame, newFragment);
        transaction.addToBackStack(null);

        transaction.commit();
    }
}
