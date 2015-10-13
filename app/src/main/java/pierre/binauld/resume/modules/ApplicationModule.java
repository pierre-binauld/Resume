package pierre.binauld.resume.modules;

import android.os.Build;

import dagger.Module;
import dagger.Provides;
import pierre.binauld.resume.activities.MainActivity;
import pierre.binauld.resume.activities.initializer.ActivityInitializer;
import pierre.binauld.resume.activities.initializer.impl.ActivityInitializerImpl;
import pierre.binauld.resume.activities.initializer.impl.TranslucentStatusBarActivityInitializer;

/**
 * A Dagger module providing application providers.
 */
@Module(
        injects = MainActivity.class
)
public class ApplicationModule {

    /**
     * Provides an activity initializer depend on the SDK version.
     * @return An activity initializer.
     */
    @Provides
    public ActivityInitializer provideActivityInitializer() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return new TranslucentStatusBarActivityInitializer(new ActivityInitializerImpl());

        } else {
            return new ActivityInitializerImpl();

        }
    }
}