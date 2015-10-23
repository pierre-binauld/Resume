package binauld.pierre.resume.view;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import binauld.pierre.resume.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A view holder for the drawer adapter.
 */
public class DrawerAdapterViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.item_text)
    public TextView textView;

    @Bind(R.id.item_icon)
    public ImageView iconView;

    /**
     * Default constructor.
     * @param view The view to hold.
     */
    public DrawerAdapterViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}