package binauld.pierre.resume.strategies.impl;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.view.transformations.CircleTransformation;
import butterknife.Bind;
import butterknife.ButterKnife;

public class NormalScreenDrawerStrategy implements DrawerStrategy {

    private DrawerStrategy strategy;
    private Fragment fragment;
    private Account account;

    @Bind(R.id.drawer_account_picture)
    public ImageView accountPictureView;

    @Bind(R.id.drawer_account_panorama)
    public ImageView accountPanoramaView;

    @Bind(R.id.drawer_account_fullname)
    public TextView fullNameView;

    @Bind(R.id.drawer_account_email)
    public TextView emailView;

    public NormalScreenDrawerStrategy(DrawerStrategy strategy) {
        this.strategy = strategy;
        this.fragment = strategy.getFragment();
        this.account = strategy.getAccount();
    }

    @Override
    public Fragment getFragment() {
        return fragment;
    }

    @Override
    public Account getAccount() {
        return account;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = strategy.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);

        Picasso
                .with(view.getContext())
                .load(account.getPictureAccount())
                .transform(new CircleTransformation())
                .resizeDimen(R.dimen.drawer_account_picture, R.dimen.drawer_account_picture)
                .centerCrop()
                .into(accountPictureView);

        Picasso
                .with(view.getContext())
                .load(account.getPicturePanorama())
                .resizeDimen(R.dimen.drawer_width, R.dimen.drawer_account_panorama_height)
                .centerCrop()
                .into(accountPanoramaView);

        fullNameView.setText(account.getFullName());
        emailView.setText(account.getEmail());

        return view;
    }

    @Override
    public void onDestroyView() {
        strategy.onDestroyView();
        ButterKnife.unbind(this);
    }
}
