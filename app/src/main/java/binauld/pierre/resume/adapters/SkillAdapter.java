package binauld.pierre.resume.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Skill;
import binauld.pierre.resume.model.SkillCategory;
import binauld.pierre.resume.view.holders.HeaderViewHolder;
import binauld.pierre.resume.view.holders.SkillViewHolder;


public class SkillAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEADER_VIEW_TYPE = 0;
    public static final int SKILL_VIEW_TYPE = 1;

    private Context context;
    private List<Object> datas;
    private List<Integer> dataTypes;

    private Drawable star;
    private Drawable emptyStar;

    public SkillAdapter(Context context, List<SkillCategory> skillCategories) {
        this.context = context;

        this.datas      = new ArrayList<>();
        this.dataTypes  = new ArrayList<>();
        for (SkillCategory category : skillCategories) {
            datas.add(category.getName());
            dataTypes.add(HEADER_VIEW_TYPE);

            datas.addAll(category);
            for (Skill skill : category) {
                dataTypes.add(SKILL_VIEW_TYPE);
            }
        }

        star = context.getResources().getDrawable(R.drawable.ic_star);
        emptyStar = context.getResources().getDrawable(R.drawable.ic_star_accent_dark);
    }

    @Override
    public int getItemViewType(int position) {
        return dataTypes.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {

            case HEADER_VIEW_TYPE:
                View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
                return new HeaderViewHolder(headerView);

            case SKILL_VIEW_TYPE:
            default:
                View skillView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skill, parent, false);
                return new SkillViewHolder(skillView);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {
            case HEADER_VIEW_TYPE:
                onBindViewHolder((HeaderViewHolder) holder, (String) datas.get(position));
                break;
            case SKILL_VIEW_TYPE:
                onBindViewHolder((SkillViewHolder) holder, (Skill) datas.get(position));
                break;
        }
    }

    public void onBindViewHolder(HeaderViewHolder holder, String name) {
        holder.title.setText(name);
    }

    public void onBindViewHolder(SkillViewHolder holder, Skill skill) {
        int rank = skill.getRank();

        holder.title.setText(skill.getName());

        Picasso
                .with(context)
                .load(skill.getPicture())
                .fit()
                .centerCrop()
                .into(holder.picture);

        holder.star1.setImageDrawable(rank < 1 ? star : emptyStar);
        holder.star2.setImageDrawable(rank < 2 ? star : emptyStar);
        holder.star3.setImageDrawable(rank < 3 ? star : emptyStar);
        holder.star4.setImageDrawable(rank < 4 ? star : emptyStar);
        holder.star5.setImageDrawable(rank < 5 ? star : emptyStar);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
