package binauld.pierre.resume.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import binauld.pierre.resume.R;
import binauld.pierre.resume.adapters.DrawerAdapter;
import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.view.DrawerViewHolder;
import binauld.pierre.resume.view.visitor.DrawerInitializer;
import butterknife.ButterKnife;


public class DrawerFragment extends Fragment {

    @Inject
    protected DrawerViewHolder viewHolder;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        ((Application) getActivity().getApplication()).getObjectGraph().inject(this);
        ButterKnife.bind(viewHolder, view);

        layoutManager = new LinearLayoutManager(this.getActivity());
        adapter = new DrawerAdapter(new Account(getResources()).getCategories());

        DrawerInitializer initializer = new DrawerInitializer(layoutManager, adapter);
        viewHolder.accept(initializer);

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
