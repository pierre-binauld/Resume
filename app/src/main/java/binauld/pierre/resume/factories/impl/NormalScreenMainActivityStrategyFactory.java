package binauld.pierre.resume.factories.impl;


import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.factories.MainActivityStrategyFactory;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.strategies.impl.NormalScreenMainActivityStrategy;

/**
 * Create a NormalScreenMainActivityStrategyFactory.
 * Decor another MainActivityStrategyFactory.
 */
public class NormalScreenMainActivityStrategyFactory implements MainActivityStrategyFactory {

    private MainActivityStrategyFactory factory;

    public NormalScreenMainActivityStrategyFactory(MainActivityStrategyFactory factory) {
        this.factory = factory;
    }

    @Override
    public MainActivityStrategy getActivityStrategy(AppCompatActivity activity, Account account) {
        MainActivityStrategy strategy = factory.getActivityStrategy(activity, account);
        return new NormalScreenMainActivityStrategy(strategy);
    }
}