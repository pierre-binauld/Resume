package binauld.pierre.resume.view.holders;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import binauld.pierre.resume.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SkillViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.card_subhead)
    public TextView title;

    @Bind(R.id.card_picture)
    public ImageView picture;

    @Bind(R.id.card_star_1)
    public ImageView star1;

    @Bind(R.id.card_star_2)
    public ImageView star2;

    @Bind(R.id.card_star_3)
    public ImageView star3;

    @Bind(R.id.card_star_4)
    public ImageView star4;

    @Bind(R.id.card_star_5)
    public ImageView star5;

    public SkillViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}
