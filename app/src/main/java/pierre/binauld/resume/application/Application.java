package pierre.binauld.resume.application;

import dagger.ObjectGraph;
import pierre.binauld.resume.modules.ApplicationModule;

/**
 * Android application class providing the dagger object graph.
 */
public class Application extends android.app.Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        objectGraph = ObjectGraph.create(new ApplicationModule());
    }

    public ObjectGraph getObjectGraph() {
        return objectGraph;
    }
}