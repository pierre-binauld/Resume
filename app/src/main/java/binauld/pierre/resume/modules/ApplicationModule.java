package binauld.pierre.resume.modules;

import android.content.Context;

import javax.inject.Singleton;

import binauld.pierre.resume.model.Account;
import dagger.Module;
import dagger.Provides;

/**
 * A Dagger module providing application providers.
 */
@Module(
        library = true
)
public class ApplicationModule {

    public Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    /**
     * Provides the current account use by the app.
     * @return The account.
     */
    @Provides @Singleton
    public Account provideAccount() {
        return new Account(context.getResources());
    }
}