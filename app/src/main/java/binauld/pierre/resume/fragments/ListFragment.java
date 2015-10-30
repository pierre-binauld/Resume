package binauld.pierre.resume.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import binauld.pierre.resume.R;
import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.factories.LayoutManagerFactory;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    @Inject
    protected LayoutManagerFactory layoutManagerFactory;

    @Bind(R.id.fragment_list_view)
    protected RecyclerView listView;

    private RecyclerView.Adapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ((Application) getActivity().getApplication()).getObjectGraph().inject(this);
        ButterKnife.bind(this, view);

        listView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = layoutManagerFactory.getLayoutManager(this.getActivity());
        listView.setLayoutManager(layoutManager);

        listView.setAdapter(adapter);

        return view;
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }
}
