package pierre.binauld.resume.application;

import dagger.ObjectGraph;
import pierre.binauld.resume.modules.ApplicationModule;

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