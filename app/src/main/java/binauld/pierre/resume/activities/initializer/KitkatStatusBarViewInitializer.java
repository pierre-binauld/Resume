package binauld.pierre.resume.activities.initializer;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.MainActivityViewHolderVisitor;
import binauld.pierre.resume.view.impl.GeneralMainActivityViewHolder;
import binauld.pierre.resume.view.impl.NormalScreenMainActivityViewHolder;

/**
 * Initialize activity views for kitkat.
 * Set up the color of the action bar.
 */
public class KitkatStatusBarViewInitializer implements MainActivityViewHolderVisitor {

    private MainActivityViewHolderVisitor visitor;

    /**
     * Default constructor.
     * Decor another MainActivityViewHolderVisitor.
     * @param visitor The other MainActivityViewHolderVisitor.
     */
    public KitkatStatusBarViewInitializer(MainActivityViewHolderVisitor visitor) {
        this.visitor = visitor;
    }

    @Override
    public void visit(AppCompatActivity activity, GeneralMainActivityViewHolder viewHolder) {
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
