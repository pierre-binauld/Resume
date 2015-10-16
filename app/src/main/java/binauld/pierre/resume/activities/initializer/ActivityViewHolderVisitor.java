package binauld.pierre.resume.activities.initializer;

import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.activities.view.impl.MainActivityViewHolder;
import binauld.pierre.resume.activities.view.impl.NormalScreenMainActivityViewHolder;

/**
 * Visitor for an ActivityViewHolder.
 * See visitor pattern.
 */
public interface ActivityViewHolderVisitor {

    /**
     * Visit a MainActivityViewHolder and do stuff.
     * @param activity The activity which the views are attached on.
     * @param viewHolder The MainActivityViewHolder.
     */
    void visit(AppCompatActivity activity, MainActivityViewHolder viewHolder);

    /**
     * Visit a NormalScreenMainActivityViewHolder and do stuff.
     * @param activity The activity which the views are attached on.
     * @param viewHolder The NormalScreenMainActivityViewHolder.
     */
    void visit(AppCompatActivity activity, NormalScreenMainActivityViewHolder viewHolder);
}
