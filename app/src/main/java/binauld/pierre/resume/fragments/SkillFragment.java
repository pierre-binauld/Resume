package binauld.pierre.resume.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import binauld.pierre.resume.R;
import binauld.pierre.resume.adapters.SkillAdapter;
import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.factories.impl.SmallItemLayoutManagerFactory;
import binauld.pierre.resume.model.Account;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SkillFragment extends Fragment {

    @Inject
    protected SmallItemLayoutManagerFactory layoutManagerFactory;

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

        final SkillAdapter adapter = buildAdapter();

        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                int viewType = adapter.getItemViewType(position);
                switch (viewType) {
                    case SkillAdapter.HEADER_VIEW_TYPE:
                        return 2;
                    case SkillAdapter.SKILL_VIEW_TYPE:
                    default:
                        return 1;
                }
            }
        };

        listView.setLayoutManager(layoutManagerFactory.getLayoutManager(getActivity(), spanSizeLookup));

        listView.setAdapter(buildAdapter());

        return view;
    }

    protected SkillAdapter buildAdapter() {
        SkillAdapter adapter = new SkillAdapter(
                getActivity(),
                account.getSkillCategories()
        );
        return adapter;
    }

//    @Override
//    protected RecyclerView.LayoutManager buildLayoutManager() {
//        return layoutManagerFactory.getLayoutManager(getActivity());
//    }
}
