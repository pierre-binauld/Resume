package binauld.pierre.resume.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Education;
import binauld.pierre.resume.view.EducationViewHolder;

public class EducationAdapter extends RecyclerView.Adapter<EducationViewHolder> {

    private Context context;
    private List<Education> educations;

    public EducationAdapter(Context context, List<Education> educations) {
        this.context = context;
        this.educations = educations;
    }

    @Override
    public EducationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);

        return new EducationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EducationViewHolder holder, int position) {
        Education education = educations.get(position);

        Picasso
                .with(context)
                .load(education.getPicture())
                .into(holder.picture);

        holder.primaryTitle.setText(education.getSchool());
        holder.primarySubtitle.setText(education.getField());

        holder.action1.setTag(education.getPlace());
        Picasso
                .with(context)
                .load(R.drawable.ic_room)
                .into(holder.action1);

        holder.action2.setTag(education.getWebSite());
        Picasso
                .with(context)
                .load(R.drawable.ic_browse)
                .into(holder.action2);
    }

    @Override
    public int getItemCount() {
        return educations.size();
    }
}
