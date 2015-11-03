package binauld.pierre.resume.view.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.ChipsContainer;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Hold views for education list item.
 */
public class ExperienceViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.card_picture)
    public ImageView picture;

    @Bind(R.id.card_primary_title)
    public TextView primaryTitle;

    @Bind(R.id.card_primary_subtitle)
    public TextView primarySubtitle;

    @Bind(R.id.card_date_range_text_start)
    public TextView dateRangeStart;

    @Bind(R.id.card_date_range_text_end)
    public TextView dateRangeEnd;

    @Bind(R.id.card_chips_container)
    public ChipsContainer chipsContainer;

    @Bind(R.id.card_action_1)
    public ImageButton action1;

    @Bind(R.id.card_action_2)
    public ImageButton action2;

    public ExperienceViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}