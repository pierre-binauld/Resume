package binauld.pierre.resume.factories;

import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;

/**
 * Define an interface for creating a MainActivityStrategyFactory.
 */
public interface MainActivityStrategyFactory {

    MainActivityStrategy getActivityStrategy(AppCompatActivity activity, Account account);
}
