package binauld.pierre.resume.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import binauld.pierre.resume.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class EducationViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.education_text)
    public TextView textView;

    public EducationViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }
}