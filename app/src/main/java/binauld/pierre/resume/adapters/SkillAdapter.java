package binauld.pierre.resume.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Skill;
import binauld.pierre.resume.view.holders.SkillViewHolder;


public class SkillAdapter extends RecyclerView.Adapter<SkillViewHolder> {

    private Context context;
    private List<Skill> skills;

    float primaryAlpha;
    float iconAlpha;

    public SkillAdapter(Context context, List<Skill> skills) {
        this.context = context;
        this.skills = skills;

        TypedValue primaryAlphaValue = new TypedValue();
        context.getResources().getValue(R.fraction.dark_on_light_primary, primaryAlphaValue, true);
        primaryAlpha = primaryAlphaValue.getFloat();

        TypedValue iconAlphaValue = new TypedValue();
        context.getResources().getValue(R.fraction.icon_disabled, iconAlphaValue, true);
        iconAlpha = iconAlphaValue.getFloat();
    }

    @Override
    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill, parent, false);

        return new SkillViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final SkillViewHolder holder, int position) {
        final Skill skill = skills.get(position);
        int rank = skill.getRank();

        holder.title.setText(skill.getName());

        Picasso
                .with(context)
                .load(skill.getPicture())
                .fit()
                .centerCrop()
                .into(holder.picture);

        Picasso
                .with(context)
                .load(rank < 1 ? R.drawable.ic_star : R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star1);
        holder.star1.setAlpha(
                rank < 1 ? iconAlpha : primaryAlpha
        );

        Picasso
                .with(context)
                .load(rank < 2 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star2);
        holder.star2.setAlpha(
                rank < 2 ? iconAlpha : primaryAlpha
        );

        Picasso
                .with(context)
                .load(rank < 3 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star3);
        holder.star3.setAlpha(
                rank < 3 ? iconAlpha : primaryAlpha
        );

        Picasso
                .with(context)
                .load(rank < 4 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star4);
        holder.star4.setAlpha(
                rank < 4 ? iconAlpha : primaryAlpha
        );

        Picasso
                .with(context)
                .load(rank < 5 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star5);
        holder.star5.setAlpha(
                rank < 5 ? iconAlpha : primaryAlpha
        );
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }
}
