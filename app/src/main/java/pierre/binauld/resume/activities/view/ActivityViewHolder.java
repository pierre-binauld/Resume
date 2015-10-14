package pierre.binauld.resume.activities.view;


import android.support.v7.app.AppCompatActivity;

import pierre.binauld.resume.activities.initializer.ActivityViewHolderVisitor;

/**
 * An activity view holder hold views of an activity.
 * This allows to have different views depend on configuration.
 */
public interface ActivityViewHolder {

     /**
      * Accept a visitor to interact with the right class.
      * See visitor pattern.
      * @param activity The activity which the views are attached on.
      * @param activityViewHolderVisitor The visitor which interact with views.
      */
     void accept(AppCompatActivity activity, ActivityViewHolderVisitor activityViewHolderVisitor);
}
