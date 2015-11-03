package binauld.pierre.resume.fragments.impl;


import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import binauld.pierre.resume.adapters.SkillAdapter;
import binauld.pierre.resume.factories.impl.SmallItemLayoutManagerFactory;
import binauld.pierre.resume.fragments.ListFragment;

public class SkillFragment extends ListFragment {

    @Inject
    protected SmallItemLayoutManagerFactory layoutManagerFactory;

    @Override
    protected RecyclerView.Adapter buildAdapter() {
        SkillAdapter adapter = new SkillAdapter(
                getActivity(),
                account.getSkills()
        );
        return adapter;
    }

    @Override
    protected RecyclerView.LayoutManager buildLayoutManager() {
        return layoutManagerFactory.getLayoutManager(getActivity());
    }
}
