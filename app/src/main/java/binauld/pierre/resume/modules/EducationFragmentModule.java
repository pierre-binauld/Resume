package binauld.pierre.resume.modules;


import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import javax.inject.Singleton;

import binauld.pierre.resume.adapters.EducationAdapter;
import binauld.pierre.resume.fragments.EducationFragment;
import binauld.pierre.resume.listeners.BrowserListener;
import binauld.pierre.resume.listeners.LocationListener;
import binauld.pierre.resume.model.Account;
import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                EducationFragment.class
        },
        complete = false,
        library = true,
        addsTo = ApplicationModule.class
)
public class EducationFragmentModule {

    private Context context;

    public EducationFragmentModule(Fragment fragment) {
        this.context = fragment.getActivity();
    }

    @Provides @Singleton
    public RecyclerView.Adapter provideAdapter(Account account, LocationListener locationListener, BrowserListener browserListener) {
        EducationAdapter adapter = new EducationAdapter(
                context,
                account.getEducations()
        );
        adapter.setLocationListener(locationListener);
        adapter.setBrowserListener(browserListener);
        return adapter;
    }

    @Provides @Singleton
    public RecyclerView.LayoutManager provideLayoutManager(Account account, RecyclerView.Adapter adapter) {
        int screenSize = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        int orientation = context.getResources().getConfiguration().orientation;

        RecyclerView.LayoutManager layoutManager;

        if ((screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) &&
                orientation == Configuration.ORIENTATION_LANDSCAPE) {
            layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        } else {
            layoutManager = new LinearLayoutManager(context);
        }

        return layoutManager;
    }

    @Provides @Singleton
    public BrowserListener provideBrowserListener() {
        return new BrowserListener(context);
    }

    @Provides @Singleton
    public LocationListener provideLocationListener() {
        return new LocationListener(context);
    }
}
