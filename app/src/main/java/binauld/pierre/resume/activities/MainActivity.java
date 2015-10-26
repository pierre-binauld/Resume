package binauld.pierre.resume.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import binauld.pierre.resume.R;
import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.strategies.factory.MainActivityStrategyFactory;

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
}
