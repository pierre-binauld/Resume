package binauld.pierre.resume.activities.initializer.impl;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import binauld.pierre.resume.R;
import binauld.pierre.resume.activities.initializer.ActivityViewHolderVisitor;
import binauld.pierre.resume.activities.view.impl.MainActivityViewHolder;
import binauld.pierre.resume.activities.view.impl.NormalScreenMainActivityViewHolder;

/**
 * Initialize activity views for kitkat.
 * Set up the color of the action bar.
 */
public class KitkatStatusBarViewInitializer implements ActivityViewHolderVisitor {

    private ActivityViewHolderVisitor visitor;

    /**
     * Default constructor.
     * Decor another ActivityViewHolderVisitor.
     * @param visitor The other ActivityViewHolderVisitor.
     */
    public KitkatStatusBarViewInitializer(ActivityViewHolderVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public void visit(AppCompatActivity activity, MainActivityViewHolder viewHolder) {
        visitor.visit(activity, viewHolder);

        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(ContextCompat.getColor(activity, R.color.status_bar_color));
    }

    @Override
    public void visit(AppCompatActivity activity, NormalScreenMainActivityViewHolder viewHolder) {
        visitor.visit(activity, viewHolder);
    }

}
