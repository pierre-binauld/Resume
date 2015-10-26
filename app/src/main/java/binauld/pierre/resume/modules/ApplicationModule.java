package binauld.pierre.resume.modules;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import javax.inject.Singleton;

import binauld.pierre.resume.activities.MainActivity;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.factory.MainActivityStrategyFactory;
import binauld.pierre.resume.strategies.factory.impl.GeneralMainActivityStrategyFactory;
import binauld.pierre.resume.strategies.factory.impl.KitkatMainActivityStrategyFactory;
import binauld.pierre.resume.strategies.factory.impl.NormalScreenMainActivityStrategyFactory;
import dagger.Module;
import dagger.Provides;

/**
 * A Dagger module providing application providers.
 */
@Module(
        injects = {
                MainActivity.class
        }
)
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }


    @Provides
    public MainActivityStrategyFactory provideMainActivityStrategyFactory() {

        int screenSize = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        MainActivityStrategyFactory factory = new GeneralMainActivityStrategyFactory();

        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                factory = new NormalScreenMainActivityStrategyFactory(factory);
                break;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
            default:
                break;
        }

        switch (Build.VERSION.SDK_INT) {
            case Build.VERSION_CODES.KITKAT:
                factory = new KitkatMainActivityStrategyFactory(factory);
                break;
        }

        return factory;
    }

    /**
     * Provide the current account use by the app.
     * @return The account.
     */
    @Provides @Singleton
    public Account provideAccount() {
        return new Account(context.getResources());
    }
}