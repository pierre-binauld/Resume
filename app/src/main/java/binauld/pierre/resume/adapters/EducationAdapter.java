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
import binauld.pierre.resume.model.Education;
import binauld.pierre.resume.tasks.PicassoLoaderTask;
import binauld.pierre.resume.view.holders.EducationViewHolder;

/**
 * A RecyclerView Adaptater for a list displaying education item.
 */
public class EducationAdapter extends RecyclerView.Adapter<EducationViewHolder> {

    private Context context;
    private List<Education> educations;
    private LocationListener locationListener;
    private BrowserListener browserListener;

    public EducationAdapter(Context context, List<Education> educations) {
        this.context = context;
        this.educations = educations;
    }

    @Override
    public EducationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_education, parent, false);

        EducationViewHolder holder = new EducationViewHolder(v);

        holder.dateRangeEndLabel.setText(R.string.education_date_range_end);

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

        return new EducationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EducationViewHolder holder, int position) {
        Education education = educations.get(position);

//        Picasso
//                .with(context)
//                .load(education.getPicture())
//                .fit()
//                .centerCrop()
//                .into(holder.picture);
        new PicassoLoaderTask(context, education.getPicture(), holder.picture).execute();

        holder.primaryTitle.setText(    education.getSchool());
        holder.primarySubtitle.setText( education.getField());
        holder.dateRangeStart.setText(  education.getStart());
        holder.dateRangeEnd.setText(    education.getEnd());

        holder.action1.setTag(education.getLocation());
        holder.action2.setTag(education.getWebPage());
    }

    @Override
    public int getItemCount() {
        return educations.size();
    }

    public void setLocationListener(LocationListener locationListener) {
        this.locationListener = locationListener;
    }

    public void setBrowserListener(BrowserListener browserListener) {
        this.browserListener = browserListener;
    }
}
