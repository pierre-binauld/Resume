package binauld.pierre.resume.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.model.Category;
import binauld.pierre.resume.view.DrawerAdapterViewHolder;

/**
 * A recycler view adapter for drawer item list.
 */
public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapterViewHolder> {

    private List<Category> categories;

    /**
     * Default constructor with categories as data set.
     * @param categories The data set.
     */
    public DrawerAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public DrawerAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_item, parent, false);

        return new DrawerAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DrawerAdapterViewHolder holder, int position) {
        Category category = categories.get(position);

        Context context = holder.iconView.getContext();

        holder.textView.setText(category.getName());
        Picasso.with(context).load(category.getIcon()).into(holder.iconView);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}