package binauld.pierre.resume.strategies.factory.impl;


import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.strategies.factory.MainActivityStrategyFactory;
import binauld.pierre.resume.strategies.impl.NormalScreenMainActivityStrategy;

public class NormalScreenMainActivityStrategyFactory implements MainActivityStrategyFactory {

    private MainActivityStrategyFactory factory;

    public NormalScreenMainActivityStrategyFactory(MainActivityStrategyFactory factory) {
        this.factory = factory;
    }

    @Override
    public MainActivityStrategy getActivityStrategy(AppCompatActivity activity) {
        MainActivityStrategy strategy = factory.getActivityStrategy(activity);
        return new NormalScreenMainActivityStrategy(strategy);
    }
}
