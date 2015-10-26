package binauld.pierre.resume.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import binauld.pierre.resume.application.Application;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.strategies.factory.DrawerStrategyFactory;

/**
 * This is the drawer of the application.
 */
public class DrawerFragment extends Fragment {

    @Inject
    protected Account account;

    @Inject
    protected DrawerStrategyFactory strategyFactory;

    private DrawerStrategy strategy;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((Application) getActivity().getApplication()).getObjectGraph().inject(this);

        strategy = strategyFactory.getActivityStrategy(this, account);

        return strategy.onCreateView(inflater, container, savedInstanceState);
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        strategy.onDestroyView();
    }
}
