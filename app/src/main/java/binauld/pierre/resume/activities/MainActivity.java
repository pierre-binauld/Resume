package binauld.pierre.resume.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import binauld.pierre.resume.R;
import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.factories.MainActivityStrategyFactory;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected Account account;

    @Inject
    protected MainActivityStrategyFactory strategyFactory;

    protected MainActivityStrategy strategy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((Application) getApplication()).getObjectGraph().inject(this);

        strategy = strategyFactory.getActivityStrategy(this, account);

        strategy.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        strategy.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if ( ! strategy.onBackPressed() ) {
            super.onBackPressed();
        }
    }
}
