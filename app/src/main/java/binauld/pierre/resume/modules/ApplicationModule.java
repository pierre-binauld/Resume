package binauld.pierre.resume.modules;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import binauld.pierre.resume.activities.MainActivity;
import binauld.pierre.resume.fragments.DrawerFragment;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.strategies.factory.MainActivityStrategyFactory;
import binauld.pierre.resume.strategies.factory.impl.GeneralMainActivityStrategyFactory;
import binauld.pierre.resume.strategies.factory.impl.KitkatMainActivityStrategyFactory;
import binauld.pierre.resume.strategies.factory.impl.NormalScreenMainActivityStrategyFactory;
import binauld.pierre.resume.strategies.impl.GeneralDrawerStrategy;
import dagger.Module;
import dagger.Provides;

/**
 * A Dagger module providing application providers.
 */
@Module(
        injects = {
                MainActivity.class,
                DrawerFragment.class
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

        MainActivityStrategyFactory strategy = new GeneralMainActivityStrategyFactory();

        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                strategy = new NormalScreenMainActivityStrategyFactory(strategy);
                break;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
            default:
                break;
        }

        switch (Build.VERSION.SDK_INT) {
            case Build.VERSION_CODES.KITKAT:
                strategy = new KitkatMainActivityStrategyFactory(strategy);
                break;
        }

        return strategy;
    }

    /**
     * Provide a strategy for the drawer fragment.
     * @return Return a strategy.
     */
    @Provides
    public DrawerStrategy provideDrawerStrategy() {

        return new GeneralDrawerStrategy();
    }
}