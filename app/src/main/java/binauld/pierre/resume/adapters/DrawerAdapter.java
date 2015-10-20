package binauld.pierre.resume.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import binauld.pierre.resume.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.DrawerAdapterViewHolder> {

    private List<String> categories;

    public static class DrawerAdapterViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_text)
        public TextView textView;

        public DrawerAdapterViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public DrawerAdapter(List<String> categories) {
        this.categories = categories;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public DrawerAdapter.DrawerAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_item, parent, false);

        DrawerAdapterViewHolder vh = new DrawerAdapterViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(DrawerAdapter.DrawerAdapterViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(categories.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return categories.size();
    }
}