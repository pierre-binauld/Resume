package binauld.pierre.resume.view;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.HashMap;
import java.util.Map;

public class AdapterSpanSizeLookup extends GridLayoutManager.SpanSizeLookup {

    private Map<Integer, Integer> spanSizes = new HashMap<>();

    private RecyclerView.Adapter adapter;

    public AdapterSpanSizeLookup(RecyclerView.Adapter adapter) {
        this.adapter = adapter;
    }

    public void putSpanSize(int viewType, int spanSize) {
        spanSizes.put(viewType, spanSize);
    }

    @Override
    public int getSpanSize(int position) {
        return spanSizes.get(
                adapter.getItemViewType(
                        position
                )
        );
    }
}
