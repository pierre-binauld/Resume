package pierre.binauld.resume.toolbar.factory;


import android.os.Build;

import pierre.binauld.resume.toolbar.impl.ToolbarInitializerImpl;
import pierre.binauld.resume.toolbar.impl.TranslucentToolbarInitializer;
import pierre.binauld.resume.toolbar.ToolbarInitializer;

public class ToolbarInitializerFactory {

    public static ToolbarInitializer getToolbarInitializer() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            return new TranslucentToolbarInitializer(new ToolbarInitializerImpl());

        } else {
            return new ToolbarInitializerImpl();

        }

    }
}
