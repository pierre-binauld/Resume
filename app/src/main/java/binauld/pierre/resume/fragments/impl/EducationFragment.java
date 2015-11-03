package binauld.pierre.resume.fragments.impl;

import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import binauld.pierre.resume.adapters.EducationAdapter;
import binauld.pierre.resume.factories.LayoutManagerFactory;
import binauld.pierre.resume.fragments.ListFragment;
import binauld.pierre.resume.listeners.BrowserListener;
import binauld.pierre.resume.listeners.LocationListener;

public class EducationFragment extends ListFragment {

    @Inject
    protected LayoutManagerFactory layoutManagerFactory;

    @Override
    protected RecyclerView.Adapter buildAdapter() {
        EducationAdapter adapter = new EducationAdapter(
                getActivity(),
                account.getEducations()
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
