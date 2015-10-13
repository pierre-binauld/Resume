package pierre.binauld.resume.modules;

import android.os.Build;

import dagger.Module;
import dagger.Provides;
import pierre.binauld.resume.MainActivity;
import pierre.binauld.resume.toolbar.ActivityInitializer;
import pierre.binauld.resume.toolbar.impl.ActivityInitializerImpl;
import pierre.binauld.resume.toolbar.impl.TranslucentStatusBarActivityInitializer;

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