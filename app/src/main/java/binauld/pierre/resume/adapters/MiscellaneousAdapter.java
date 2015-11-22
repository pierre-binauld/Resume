package binauld.pierre.resume.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.listeners.BrowserListener;
import binauld.pierre.resume.listeners.LocationListener;
import binauld.pierre.resume.model.Experience;
import binauld.pierre.resume.model.Skill;
import binauld.pierre.resume.tasks.PicassoLoaderTask;
import binauld.pierre.resume.view.holders.Experience2ViewHolder;
import binauld.pierre.resume.view.holders.ExperienceViewHolder;
import binauld.pierre.resume.view.holders.HeaderViewHolder;

public class MiscellaneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int HEADER_VIEW_TYPE        = 0;
    public static final int EXPERIENCE_VIEW_TYPE    = 1;
    public static final int VOLUNTEER_VIEW_TYPE     = 2;
    public static final int HOBBY_VIEW_TYPE         = 3;

    private Context context;

    private LocationListener locationListener;
    private BrowserListener browserListener;

    private List<Integer> positions = new ArrayList<>();
    private List<Integer> viewTypes = new ArrayList<>();
    private List<String>  headers   = new ArrayList<>();
    private List<Experience> experiences;

    public MiscellaneousAdapter(Context context, List<Experience> experiences) {

        this.context = context;

        this.experiences = experiences;

        this.addAll("Other Experiences", experiences.size(), EXPERIENCE_VIEW_TYPE);
    }

    private void addAll(String header, int size, int viewType) {

        headers.add(header);
        viewTypes.add(HEADER_VIEW_TYPE);
        positions.add(headers.size() - 1);

        int offset = viewTypes.size() - 1;

        for (int i = 0; i < size; i++) {
            viewTypes.add(viewType);
            positions.add(i + offset);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return viewTypes.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {

            case HEADER_VIEW_TYPE:
                return onCreateHeaderViewHolder(parent);

            case EXPERIENCE_VIEW_TYPE:
            default:
                return onCreateExperienceViewHolder(parent);

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        int viewType = getItemViewType(position);
        switch (viewType) {
            case HEADER_VIEW_TYPE:
                onBindViewHolder((HeaderViewHolder) holder, headers.get(positions.get(position)));
                break;
            case EXPERIENCE_VIEW_TYPE:
                onBindViewHolder((Experience2ViewHolder) holder, experiences.get(positions.get(position)));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return viewTypes.size();
    }

    public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
        View headerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header, parent, false);
        return new HeaderViewHolder(headerView);
    }

    public RecyclerView.ViewHolder onCreateExperienceViewHolder(ViewGroup parent) {
        View experienceView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_experience_2, parent, false);

        Experience2ViewHolder holder = new Experience2ViewHolder(experienceView);

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

    public void onBindViewHolder(HeaderViewHolder holder, String name) {
        holder.title.setText(name);
    }

    public void onBindViewHolder(Experience2ViewHolder holder, Experience experience) {
        new PicassoLoaderTask(context, experience.getPicture(), holder.picture).execute();
        holder.primaryTitle.setText(experience.getPosition());
        holder.primarySubtitle.setText( experience.getCompany());
        holder.dateRangeStart.setText(experience.getStart());
        holder.dateRangeEnd.setText(experience.getEnd());

        holder.action1.setTag(experience.getLocation());
        holder.action2.setTag(experience.getWebPage());
    }

    public void setLocationListener(LocationListener locationListener) {
        this.locationListener = locationListener;
    }

    public void setBrowserListener(BrowserListener browserListener) {
        this.browserListener = browserListener;
    }
}
