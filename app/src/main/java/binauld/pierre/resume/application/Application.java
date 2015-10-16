package binauld.pierre.resume.application;

import binauld.pierre.resume.modules.ApplicationModule;
import dagger.ObjectGraph;

/**
 * Android application class providing the dagger graph object.
 */
public class Application extends android.app.Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationModule applicationModule = new ApplicationModule(this);

        objectGraph = ObjectGraph.create(applicationModule);
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}