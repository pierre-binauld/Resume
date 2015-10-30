package binauld.pierre.resume.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import binauld.pierre.resume.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Hold view for education list item.
 */
public class EducationViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.card_rich_media)
    public ImageView picture;

    @Bind(R.id.card_primary_title)
    public TextView primaryTitle;

    @Bind(R.id.card_primary_subtitle)
    public TextView primarySubtitle;

    @Bind(R.id.card_action_1)
    public ImageButton action1;

    @Bind(R.id.card_action_2)
    public ImageButton action2;

    public EducationViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}