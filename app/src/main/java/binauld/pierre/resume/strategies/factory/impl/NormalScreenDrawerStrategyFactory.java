package binauld.pierre.resume.strategies.factory.impl;


import android.app.Fragment;

import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.strategies.factory.DrawerStrategyFactory;
import binauld.pierre.resume.strategies.impl.NormalScreenDrawerStrategy;

public class NormalScreenDrawerStrategyFactory implements DrawerStrategyFactory {

    private DrawerStrategyFactory strategyFactory;

    public NormalScreenDrawerStrategyFactory(DrawerStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Override
    public DrawerStrategy getActivityStrategy(Fragment fragment, Account account) {
        DrawerStrategy strategy = strategyFactory.getActivityStrategy(fragment, account);
        return new NormalScreenDrawerStrategy(strategy);
    }
}
