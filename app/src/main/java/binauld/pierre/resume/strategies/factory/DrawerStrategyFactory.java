package binauld.pierre.resume.strategies.factory;


import android.app.Fragment;

import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.DrawerStrategy;

public interface DrawerStrategyFactory {

    DrawerStrategy getActivityStrategy(Fragment fragment, Account account);
}
