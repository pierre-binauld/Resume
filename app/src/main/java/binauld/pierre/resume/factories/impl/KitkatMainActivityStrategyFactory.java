package binauld.pierre.resume.factories.impl;

import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.factories.MainActivityStrategyFactory;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.strategies.impl.KitkatMainActivityStrategy;

/**
 * Create a KitkatMainActivityStrategyFactory.
 * Decor another MainActivityStrategyFactory.
 */
public class KitkatMainActivityStrategyFactory implements MainActivityStrategyFactory {

    private MainActivityStrategyFactory factory;

    public KitkatMainActivityStrategyFactory(MainActivityStrategyFactory factory) {
        this.factory = factory;
    }

    @Override
    public MainActivityStrategy getActivityStrategy(AppCompatActivity activity, Account account) {
        MainActivityStrategy strategy = factory.getActivityStrategy(activity, account);
        return new KitkatMainActivityStrategy(strategy);
    }
}
