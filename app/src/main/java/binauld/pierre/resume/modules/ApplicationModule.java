package binauld.pierre.resume.modules;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;

import binauld.pierre.resume.activities.MainActivity;
import binauld.pierre.resume.fragments.DrawerFragment;
import binauld.pierre.resume.view.DrawerViewHolder;
import binauld.pierre.resume.view.MainActivityViewHolder;
import binauld.pierre.resume.view.MainActivityViewHolderVisitor;
import binauld.pierre.resume.view.impl.GeneralDrawerViewHolder;
import binauld.pierre.resume.view.impl.GeneralMainActivityViewHolder;
import binauld.pierre.resume.view.impl.NormalScreenMainActivityViewHolder;
import binauld.pierre.resume.view.visitor.KitkatStatusBarViewInitializer;
import binauld.pierre.resume.view.visitor.ViewInitializer;
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

    /**
     * Provides a view initializer depend on the SDK version.
     * @return A view initializer.
     */
    @Provides
    public MainActivityViewHolderVisitor provideViewInitializer() {

        MainActivityViewHolderVisitor viewInitializer = new ViewInitializer();

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
    public MainActivityViewHolder provideMainActivityViewHolder() {

        int screenSize = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;

        switch (screenSize) {
            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                return new GeneralMainActivityViewHolder();

            case Configuration.SCREENLAYOUT_SIZE_NORMAL:
            case Configuration.SCREENLAYOUT_SIZE_SMALL:
            default:
                return new NormalScreenMainActivityViewHolder();
        }

    }

    @Provides
    public DrawerViewHolder provideDrawerViewHolder() {

        return new GeneralDrawerViewHolder();

    }
}