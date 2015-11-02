package binauld.pierre.resume.view;


import android.content.Context;
import android.util.AttributeSet;

import org.apmem.tools.layouts.FlowLayout;

import binauld.pierre.resume.R;

public class ChipsContainer extends FlowLayout {
    public ChipsContainer(Context context) {
        super(context);
    }

    public ChipsContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ChipsContainer(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

    public void addChips(String text, int picture) {
        Chips chips = Chips.getChips(getContext(), text, picture);

        FlowLayout.LayoutParams params = new FlowLayout.LayoutParams(
                FlowLayout.LayoutParams.WRAP_CONTENT,
                FlowLayout.LayoutParams.WRAP_CONTENT
        );
        int margin = getContext().getResources().getDimensionPixelSize(R.dimen.chips_margin);
        params.setMargins(margin, margin, margin, margin);
        chips.setLayoutParams(params);

        this.addView(chips);
    }

    public void addChips(String text) {
        addChips(text, 0);
    }
}
