package binauld.pierre.resume.strategies.impl;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import binauld.pierre.resume.R;
import binauld.pierre.resume.adapters.DrawerAdapter;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.DrawerStrategy;
import butterknife.Bind;
import butterknife.ButterKnife;

public class GeneralDrawerStrategy implements DrawerStrategy {

    @Bind(R.id.drawer_list)
    public RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        ButterKnife.bind(this, view);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new DrawerAdapter(new Account(view.getResources()).getCategories());
        recyclerView.setAdapter(adapter);

        return view;
    }
}
