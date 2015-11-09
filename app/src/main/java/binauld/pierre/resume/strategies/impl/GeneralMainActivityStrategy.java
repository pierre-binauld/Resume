package binauld.pierre.resume.strategies.impl;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import binauld.pierre.resume.R;
import binauld.pierre.resume.fragments.EducationFragment;
import binauld.pierre.resume.fragments.ExperienceFragment;
import binauld.pierre.resume.fragments.SkillFragment;
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

    public static final String CURRENT_MENU_ITEM_ID = "currentMenuItemId";

    protected AppCompatActivity activity;

    protected Account account;

    private LocationListener locationListener;
    private BrowserListener  browserListener;

    private int currentMenuItemId;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    @Bind(R.id.left_drawer)
    public NavigationView drawer;

    public GeneralMainActivityStrategy(AppCompatActivity activity, Account account) {
        this.activity = activity;
        this.account = account;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(this, activity);

        locationListener = new LocationListener(activity);
        browserListener  = new BrowserListener(activity);

        activity.setSupportActionBar(toolbar);

        if (savedInstanceState != null) {
            currentMenuItemId = savedInstanceState.getInt(CURRENT_MENU_ITEM_ID);
        } else {
            currentMenuItemId = drawer.getMenu().getItem(0).getItemId();
        }

        drawer.setNavigationItemSelectedListener(this);
        MenuItem item = drawer.getMenu().findItem(currentMenuItemId);
        item.setChecked(true);
        onNavigationItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(CURRENT_MENU_ITEM_ID, currentMenuItemId);
    }

    @Override
    public boolean onBackPressed() {
        if (activity.getFragmentManager().getBackStackEntryCount() > 1 ){
            activity.getFragmentManager().popBackStack();
            return true;
        } else {
            return false;
        }
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
            case R.id.nav_item_experiences:
                switchToExperiencesFragment();
                break;
            case R.id.nav_item_misc:
                switchToMiscFragment();
                break;
            default:
                return false;
        }

        currentMenuItemId = menuItem.getItemId();
        activity.setTitle(menuItem.getTitle());

        return true;
    }

    /**
     * Switch to the education fragment.
     */
    private void switchToEducationFragment() {
        EducationFragment fragment = new EducationFragment();
        switchFragment(fragment);
    }

    /**
     * Switch to the skills fragment.
     */
    private void switchToSkillsFragment() {
        SkillFragment fragment = new SkillFragment();
        switchFragment(fragment);
    }


    /**
     * Switch to the experiences fragment.
     */
    private void switchToExperiencesFragment() {
        ExperienceFragment fragment = new ExperienceFragment();
        switchFragment(fragment);
    }


    /**
     * Switch to the miscellaneous fragment.
     */
    private void switchToMiscFragment() {
//        MiscFragment fragment = new MiscFragment();
//        switchFragment(fragment);
    }

    /**
     * Switch to another fragment.
     * @param newFragment The fragment to switch on.
     */
    private void switchFragment(Fragment newFragment) {
        activity.getFragmentManager()
                .beginTransaction()

                .replace(R.id.content_frame, newFragment)
                .addToBackStack(null)

                .commit();
    }
}
