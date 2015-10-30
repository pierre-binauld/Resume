package binauld.pierre.resume.listeners;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import binauld.pierre.resume.R;

/**
 * A listener listening onClick event and send an intent to start the web browser.
 * The view sender of the event must have a string url as tag.
 */
public class BrowserListener implements ImageButton.OnClickListener {

    private Context context;

    public BrowserListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String query = (String) v.getTag();
        if (null != query) {
            Uri webPage = Uri.parse(query);
            Intent intent = new Intent(Intent.ACTION_VIEW, webPage);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
            }
        } else {
            Toast.makeText(context, R.string.message_error_no_web_page, Toast.LENGTH_SHORT).show();
        }
    }
}
