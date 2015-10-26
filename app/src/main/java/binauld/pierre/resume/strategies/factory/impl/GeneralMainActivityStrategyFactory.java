package binauld.pierre.resume.strategies.factory.impl;

import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.strategies.factory.MainActivityStrategyFactory;
import binauld.pierre.resume.strategies.impl.GeneralMainActivityStrategy;

public class GeneralMainActivityStrategyFactory implements MainActivityStrategyFactory {

    @Override
    public MainActivityStrategy getActivityStrategy(AppCompatActivity activity, Account account) {
        return new GeneralMainActivityStrategy(activity, account);
    }
}
