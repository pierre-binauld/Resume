package binauld.pierre.resume.view;


import android.support.v7.app.AppCompatActivity;

/**
 * An activity view holder hold views of an activity.
 * This allows to have different views depend on configuration.
 */
public interface MainActivityViewHolder {

     /**
      * Accept a visitor to interact with the right class.
      * See visitor pattern.
      * @param activity The activity which the views are attached on.
      * @param viewHolderVisitor The visitor which interact with views.
      */
     void accept(AppCompatActivity activity, MainActivityViewHolderVisitor viewHolderVisitor);
}
