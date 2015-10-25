package binauld.pierre.resume.strategies.impl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import binauld.pierre.resume.R;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import butterknife.Bind;
import butterknife.ButterKnife;

public class GeneralMainActivityStrategy implements MainActivityStrategy {

    private AppCompatActivity activity;

    @Bind(R.id.toolbar)
    public Toolbar toolbar;

    public GeneralMainActivityStrategy(AppCompatActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
    }

    @Override
    public AppCompatActivity getActivity() {
        return activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        activity.setSupportActionBar(toolbar);
    }

}
