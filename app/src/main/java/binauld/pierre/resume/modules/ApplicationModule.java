package binauld.pierre.resume.modules;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import javax.inject.Singleton;

import binauld.pierre.resume.activities.MainActivity;
import binauld.pierre.resume.factories.LayoutManagerFactory;
import binauld.pierre.resume.factories.MainActivityStrategyFactory;
import binauld.pierre.resume.factories.impl.GeneralMainActivityStrategyFactory;
import binauld.pierre.resume.factories.impl.KitkatMainActivityStrategyFactory;
import binauld.pierre.resume.factories.impl.LinearLayoutManagerFactory;
import binauld.pierre.resume.factories.impl.NormalScreenMainActivityStrategyFactory;
import binauld.pierre.resume.factories.impl.StaggeredGridLayoutManagerFactory;
import binauld.pierre.resume.fragments.ListFragment;
import binauld.pierre.resume.model.Account;
import dagger.Module;
import dagger.Provides;

/**
 * A Dagger module providing application providers.
 */
@Module(
        injects = {
                MainActivity.class,
                ListFragment.class
        }
)
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    /**
     * Provides a MainActivityStrategyFactory depending on screen size and build version.
     * @return a MainActivityStrategyFactory.
     */
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
     * Provides the current account use by the app.
     * @return The account.
     */
    @Provides @Singleton
    public Account provideAccount() {
        return new Account(context.getResources());
    }


    /**
     * Provides a LayoutManagerFactory depending on screen size and orientation.
     * @return A StaggeredGridLayoutManagerFactory for large landscape screen or a LinearLayoutManagerFactory otherwise.
     */
    @Provides
    public LayoutManagerFactory provideLayoutManager() {
        int screenSize = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        int orientation = context.getResources().getConfiguration().orientation;

        LayoutManagerFactory factory;

        if ((screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) &&
                orientation == Configuration.ORIENTATION_LANDSCAPE) {
            factory = new StaggeredGridLayoutManagerFactory();
        } else {
            factory = new LinearLayoutManagerFactory();
        }

        return factory;
    }
}