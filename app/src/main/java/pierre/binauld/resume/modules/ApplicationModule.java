package pierre.binauld.resume.modules;

import android.os.Build;

import dagger.Module;
import dagger.Provides;
import pierre.binauld.resume.activities.MainActivity;
import pierre.binauld.resume.activities.initializer.ActivityInitializer;
import pierre.binauld.resume.activities.initializer.impl.ActivityInitializerImpl;
import pierre.binauld.resume.activities.initializer.impl.TranslucentStatusBarActivityInitializer;

@Module(
        injects = MainActivity.class
)
public class ApplicationModule {

    @Provides
    public ActivityInitializer provideActivityInitializer() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return new TranslucentStatusBarActivityInitializer(new ActivityInitializerImpl());

        } else {
            return new ActivityInitializerImpl();

        }
    }
}