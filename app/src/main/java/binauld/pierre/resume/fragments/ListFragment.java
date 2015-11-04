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
import binauld.pierre.resume.model.Account;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class ListFragment extends Fragment {

    @Inject
    protected Account account;

    @Bind(R.id.fragment_list_view)
    protected RecyclerView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ((Application) getActivity().getApplication()).getAppGraph().inject(this);
        ButterKnife.bind(this, view);

        listView.setHasFixedSize(true);

        listView.setLayoutManager(buildLayoutManager());

        listView.setAdapter(buildAdapter());

        return view;
    }

    protected abstract RecyclerView.Adapter buildAdapter();

    protected abstract RecyclerView.LayoutManager buildLayoutManager();
}
