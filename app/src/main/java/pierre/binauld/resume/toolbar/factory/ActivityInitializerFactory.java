package pierre.binauld.resume.toolbar.factory;


import android.os.Build;

import pierre.binauld.resume.toolbar.ActivityInitializer;
import pierre.binauld.resume.toolbar.impl.ActivityInitializerImpl;
import pierre.binauld.resume.toolbar.impl.TranslucentStatusBarActivityInitializer;

public class ActivityInitializerFactory {

    public static ActivityInitializer getActivityInitializer() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return new TranslucentStatusBarActivityInitializer(new ActivityInitializerImpl());

        } else {
            return new ActivityInitializerImpl();

        }

    }
}
