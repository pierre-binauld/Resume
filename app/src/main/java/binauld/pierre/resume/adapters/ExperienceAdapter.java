package binauld.pierre.resume.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.listeners.BrowserListener;
import binauld.pierre.resume.listeners.LocationListener;
import binauld.pierre.resume.model.Experience;
import binauld.pierre.resume.model.TechnicalSkill;
import binauld.pierre.resume.view.ExperienceViewHolder;

/**
 * A RecyclerView Adaptater for a list displaying experience item.
 */
public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceViewHolder> {

    private Context context;
    private List<Experience> experiences;
    private LocationListener locationListener;
    private BrowserListener browserListener;

    public ExperienceAdapter(Context context, List<Experience> experiences) {
        this.context = context;
        this.experiences = experiences;
    }

    @Override
    public ExperienceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.experience_item, parent, false);

        ExperienceViewHolder holder = new ExperienceViewHolder(v);

        holder.action1.setOnClickListener(locationListener);
        Picasso
                .with(context)
                .load(R.drawable.ic_room)
                .into(holder.action1);

        holder.action2.setOnClickListener(browserListener);
        Picasso
                .with(context)
                .load(R.drawable.ic_browse)
                .into(holder.action2);

        return holder;
    }

    @Override
    public void onBindViewHolder(ExperienceViewHolder holder, int position) {
        Experience experience = experiences.get(position);

        Picasso
                .with(context)
                .load(experience.getPicture())
                .fit()
                .centerCrop()
                .into(holder.picture);

        holder.primaryTitle.setText(experience.getPosition());
        holder.primarySubtitle.setText( experience.getCompany() );
        holder.dateRangeStart.setText(experience.getStart());
        holder.dateRangeEnd.setText(experience.getEnd());

        for (TechnicalSkill technicalSkill : experience.getTechnicalSkills()) {
            holder.chipsContainer.addChips(technicalSkill.getName(), technicalSkill.getPicture());
        }

        holder.action1.setTag(experience.getLocation());
        holder.action2.setTag(experience.getWebPage());
    }

    @Override
    public int getItemCount() {
        return experiences.size();
    }

    public void setLocationListener(LocationListener locationListener) {
        this.locationListener = locationListener;
    }

    public void setBrowserListener(BrowserListener browserListener) {
        this.browserListener = browserListener;
    }
}
