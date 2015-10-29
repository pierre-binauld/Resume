package binauld.pierre.resume.listeners;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;

public class BrowserListener implements ImageButton.OnClickListener {

    private Context context;

    public BrowserListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String query = (String) v.getTag();
        Uri webpage = Uri.parse(query);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
