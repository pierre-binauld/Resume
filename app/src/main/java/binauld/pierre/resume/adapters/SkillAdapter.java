package binauld.pierre.resume.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    public SkillAdapter(Context context, List<Skill> skills) {
        this.context = context;
        this.skills = skills;
    }

    @Override
    public SkillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill, parent, false);

        SkillViewHolder holder = new SkillViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(SkillViewHolder holder, int position) {
        Skill skill = skills.get(position);
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
                .load(rank < 1 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star1);

        Picasso
                .with(context)
                .load(rank < 2 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star2);

        Picasso
                .with(context)
                .load(rank < 3 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star3);

        Picasso
                .with(context)
                .load(rank < 4 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star4);

        Picasso
                .with(context)
                .load(rank < 5 ? R.drawable.ic_star :  R.drawable.ic_star_accent_dark)
                .fit()
                .centerCrop()
                .into(holder.star5);
    }

    @Override
    public int getItemCount() {
        return skills.size();
    }
}
