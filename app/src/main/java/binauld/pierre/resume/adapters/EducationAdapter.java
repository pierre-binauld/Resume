package binauld.pierre.resume.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.EducationViewHolder;

public class EducationAdapter extends RecyclerView.Adapter<EducationViewHolder> {

    private List<String> dataset = new ArrayList<>();

    public EducationAdapter() {
        for (int i = 0; i < 200; i++) {
            dataset.add("Education "+i);
        }
    }

    @Override
    public EducationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);

        return new EducationViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EducationViewHolder holder, int position) {
        holder.textView.setText(dataset.get(position));

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
