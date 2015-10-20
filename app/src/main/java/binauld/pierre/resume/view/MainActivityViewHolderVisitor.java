package binauld.pierre.resume.view;

import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.view.impl.GeneralMainActivityViewHolder;
import binauld.pierre.resume.view.impl.NormalScreenMainActivityViewHolder;

/**
 * Visitor for an ViewHolder.
 * See visitor pattern.
 */
public interface MainActivityViewHolderVisitor {

    /**
     * Visit a MainActivityViewHolder and do stuff.
     * @param activity The activity which the views are attached on.
     * @param viewHolder The MainActivityViewHolder.
     */
    void visit(AppCompatActivity activity, GeneralMainActivityViewHolder viewHolder);

    /**
     * Visit a NormalScreenMainActivityViewHolder and do stuff.
     * @param activity The activity which the views are attached on.
     * @param viewHolder The NormalScreenMainActivityViewHolder.
     */
    void visit(AppCompatActivity activity, NormalScreenMainActivityViewHolder viewHolder);
}
