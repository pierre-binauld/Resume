package binauld.pierre.resume.strategies.impl;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.model.Category;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.view.DrawerAdapterViewHolder;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Define a general strategy for a drawer fragment.
 */
public class GeneralDrawerStrategy implements DrawerStrategy {

    private Fragment fragment;
    private Account account;

    @Bind(R.id.drawer_list)
    public LinearLayout listItemLayout;

    public GeneralDrawerStrategy(Fragment fragment, Account account) {
        this.fragment = fragment;
        this.account = account;
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
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        ButterKnife.bind(this, view);

        for (Category category : account.getCategories()) {
            View vi = inflater.inflate(R.layout.drawer_item, listItemLayout, false);
            DrawerAdapterViewHolder holder = new DrawerAdapterViewHolder(vi);

            holder.textView.setText(category.getName());
            Picasso.with(vi.getContext())
                    .load(category.getIcon())
                    .into(holder.iconView);
            listItemLayout.addView(vi);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
    }
}
