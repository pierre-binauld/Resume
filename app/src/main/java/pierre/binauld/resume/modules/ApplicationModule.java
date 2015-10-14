package pierre.binauld.resume.modules;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import dagger.Module;
import dagger.Provides;
import pierre.binauld.resume.activities.MainActivity;
import pierre.binauld.resume.activities.initializer.ActivityViewHolderVisitor;
import pierre.binauld.resume.activities.initializer.impl.KitkatStatusBarViewInitializer;
import pierre.binauld.resume.activities.initializer.impl.ViewInitializer;
import pierre.binauld.resume.activities.view.ActivityViewHolder;
import pierre.binauld.resume.activities.view.impl.MainActivityViewHolder;
import pierre.binauld.resume.activities.view.impl.PhoneMainActivityViewHolder;

/**
 * A Dagger module providing application providers.
 */
@Module(
        injects = MainActivity.class
)
public class ApplicationModule {

    private final Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    /**
     * Provides a view initializer depend on the SDK version.
     * @return A view initializer.
     */
    @Provides
    public ActivityViewHolderVisitor provideViewInitializer() {

        ActivityViewHolderVisitor viewInitializer = new ViewInitializer();

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            viewInitializer = new KitkatStatusBarViewInitializer(viewInitializer);
        }

        return viewInitializer;
    }

    /**
     * Provides an activity view holder depend on the screen size.
     * @return A view initializer.
     */
    @Provides
    public ActivityViewHolder provideActivityViewHolder() {

        int screenSize = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return new MainActivityViewHolder();

            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
            default:
                return new PhoneMainActivityViewHolder();
        }

    }
}