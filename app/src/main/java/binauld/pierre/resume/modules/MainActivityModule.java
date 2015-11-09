package binauld.pierre.resume.modules;

import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.activities.MainActivity;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.MainActivityStrategy;
import binauld.pierre.resume.strategies.impl.GeneralMainActivityStrategy;
import binauld.pierre.resume.strategies.impl.KitkatMainActivityStrategy;
import binauld.pierre.resume.strategies.impl.NormalScreenMainActivityStrategy;
import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                MainActivity.class
        },
        complete = false,
        library = true,
        addsTo = ApplicationModule.class
)
public class MainActivityModule {

    public AppCompatActivity activity;

    public MainActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    /**
     * Provides a MainActivityStrategy depending on screen size and build version.
     * @return a MainActivityStrategy.
     */
    @Provides
    public MainActivityStrategy provideMainActivityStrategy(Account account) {

        int screenSize = activity.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        MainActivityStrategy strategy = new GeneralMainActivityStrategy(activity, account);

        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
                strategy = new NormalScreenMainActivityStrategy(activity, account, strategy);
                break;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
            default:
                break;
        }

        switch (Build.VERSION.SDK_INT) {
            case Build.VERSION_CODES.KITKAT:
                strategy = new KitkatMainActivityStrategy(activity, strategy);
                break;
        }

        return strategy;
    }
}
