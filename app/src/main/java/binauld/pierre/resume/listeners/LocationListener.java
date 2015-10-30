package binauld.pierre.resume.listeners;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import binauld.pierre.resume.R;

/**
 * A listener listening onClick event and send an intent to start the a geo localisation application.
 * The view sender of the event must have a string location as tag.
 */
public class LocationListener implements ImageButton.OnClickListener {

    private Context context;

    public LocationListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String query = (String) v.getTag();
        if (null != query) {
            Uri geo = Uri.parse("geo:0,0?q=" + query);
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(geo);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } else {
            Toast.makeText(context, R.string.message_error_no_location, Toast.LENGTH_SHORT).show();
        }
    }
}
