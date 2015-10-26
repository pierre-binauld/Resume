package binauld.pierre.resume.strategies.impl;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.model.Category;
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

        Menu menu = drawer.getMenu();
        for (Category category : account.getCategories()) {
            menu.add(category.getName()).setIcon(category.getIcon());
        }
    }

}
