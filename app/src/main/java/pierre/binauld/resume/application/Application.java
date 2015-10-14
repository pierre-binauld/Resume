package pierre.binauld.resume.application;

import dagger.ObjectGraph;
import pierre.binauld.resume.modules.ApplicationModule;

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