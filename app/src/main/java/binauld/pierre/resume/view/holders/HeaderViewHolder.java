package binauld.pierre.resume.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import binauld.pierre.resume.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class HeaderViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.header_title)
    public TextView title;

    public HeaderViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
