package binauld.pierre.resume.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.strategies.DrawerStrategy;
import butterknife.ButterKnife;

/**
 * This is the drawer of the application.
 */
public class DrawerFragment extends Fragment {

    @Inject
    protected DrawerStrategy strategy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((Application) getActivity().getApplication()).getObjectGraph().inject(this);

        View view = strategy.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
