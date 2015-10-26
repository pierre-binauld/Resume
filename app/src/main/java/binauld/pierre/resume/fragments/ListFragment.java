package binauld.pierre.resume.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import binauld.pierre.resume.R;
import binauld.pierre.resume.adapters.EducationAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    @Bind(R.id.fragment_list_view)
    protected RecyclerView listView;



    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        ButterKnife.bind(this, view);

        listView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        listView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new EducationAdapter();
        listView.setAdapter(adapter);

        return view;
    }


}
