package binauld.pierre.resume.strategies.factory.impl;

import android.app.Fragment;

import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.strategies.factory.DrawerStrategyFactory;
import binauld.pierre.resume.strategies.impl.GeneralDrawerStrategy;

public class GeneralDrawerStrategyFactory implements DrawerStrategyFactory {

    @Override
    public DrawerStrategy getActivityStrategy(Fragment fragment, Account account) {
        return new GeneralDrawerStrategy(fragment, account);
    }
}
