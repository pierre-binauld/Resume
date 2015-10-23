package binauld.pierre.resume.strategies.impl;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Account;
import binauld.pierre.resume.model.Category;
import binauld.pierre.resume.strategies.DrawerStrategy;
import binauld.pierre.resume.view.DrawerAdapterViewHolder;
import binauld.pierre.resume.view.transformations.CircleTransformation;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Define a general strategy for a drawer fragment.
 */
public class GeneralDrawerStrategy implements DrawerStrategy {

    @Bind(R.id.drawer_list)
    public LinearLayout listItemLayout;

    @Bind(R.id.drawer_account_picture)
    public ImageView accountPictureView;

    @Bind(R.id.drawer_account_panorama)
    public ImageView accountPanoramaView;

    @Bind(R.id.drawer_account_fullname)
    public TextView fullNameView;

    @Bind(R.id.drawer_account_email)
    public TextView emailView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drawer, container, false);
        ButterKnife.bind(this, view);

        Account account = new Account(view.getResources());

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

        for (Category category : account.getCategories()) {
            View vi = inflater.inflate(R.layout.drawer_item, listItemLayout, false);
            DrawerAdapterViewHolder holder = new DrawerAdapterViewHolder(vi);

            holder.textView.setText(category.getName());
            Picasso.with(vi.getContext())
                    .load(category.getIcon())
                    .into(holder.iconView);
            listItemLayout.addView(vi);
        }

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
//        RecyclerView.Adapter adapter             = new DrawerAdapter(account.getCategories());
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

        return view;
    }
}
