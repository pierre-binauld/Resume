package binauld.pierre.resume.strategies.factory;

import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;

public interface MainActivityStrategyFactory {

    MainActivityStrategy getActivityStrategy(AppCompatActivity activity, Account account);
}
