package binauld.pierre.resume.modules;


import android.app.Fragment;
import android.content.Context;
import android.content.res.Configuration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Singleton;

import binauld.pierre.resume.adapters.SkillAdapter;
import binauld.pierre.resume.fragments.SkillFragment;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.view.AdapterSpanSizeLookup;
import dagger.Module;
import dagger.Provides;

@Module(
        injects = {
                SkillFragment.class
        },
        complete = false,
        library = true,
        addsTo = ApplicationModule.class
)
public class SkillFragmentModule {

    private Context context;

    public SkillFragmentModule(Fragment fragment) {
        this.context = fragment.getActivity();
    }

    @Provides
    @Singleton
    public RecyclerView.Adapter provideAdapter(Account account) {
        SkillAdapter adapter = new SkillAdapter(
                context,
                account.getSkillCategories()
        );
        return adapter;
    }

    @Provides @Singleton
    public RecyclerView.LayoutManager provideLayoutManager(Account account, RecyclerView.Adapter adapter) {
        int screenSize = context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        int orientation = context.getResources().getConfiguration().orientation;

        int spanCount;

        if ((screenSize == Configuration.SCREENLAYOUT_SIZE_XLARGE || screenSize == Configuration.SCREENLAYOUT_SIZE_LARGE) &&
                orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3;
        } else {
            spanCount = 2;
        }

        AdapterSpanSizeLookup spanSizeLookup = new AdapterSpanSizeLookup(adapter);
        spanSizeLookup.putSpanSize(SkillAdapter.HEADER_VIEW_TYPE, spanCount);
        spanSizeLookup.putSpanSize(SkillAdapter.SKILL_VIEW_TYPE, 1);

        GridLayoutManager layoutManager = new GridLayoutManager(context, spanCount);
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        return layoutManager;
    }
}
