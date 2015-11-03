package binauld.pierre.resume.fragments.impl;

import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import binauld.pierre.resume.adapters.ExperienceAdapter;
import binauld.pierre.resume.factories.LayoutManagerFactory;
import binauld.pierre.resume.fragments.ListFragment;
import binauld.pierre.resume.listeners.BrowserListener;
import binauld.pierre.resume.listeners.LocationListener;

public class ExperienceFragment extends ListFragment {

    @Inject
    protected LayoutManagerFactory layoutManagerFactory;

    @Override
    protected RecyclerView.Adapter buildAdapter() {
        ExperienceAdapter adapter = new ExperienceAdapter(
                getActivity(),
                account.getExperiences()
        );
        adapter.setLocationListener(new LocationListener(getActivity()));
        adapter.setBrowserListener(new BrowserListener(getActivity()));
        return adapter;
    }

    @Override
    protected RecyclerView.LayoutManager buildLayoutManager() {
        return layoutManagerFactory.getLayoutManager(getActivity());
    }
}
