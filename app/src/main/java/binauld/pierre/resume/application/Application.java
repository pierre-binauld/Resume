package binauld.pierre.resume.application;

import binauld.pierre.resume.modules.ApplicationModule;
import dagger.ObjectGraph;

/**
 * Android application class providing the dagger graph object.
 */
public class Application extends android.app.Application {

    private ObjectGraph appGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationModule applicationModule = new ApplicationModule(this);

        appGraph = ObjectGraph.create(applicationModule);
    }

    public ObjectGraph getAppGraph() {
        return appGraph;
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return appGraph.plus(modules);
    }
}