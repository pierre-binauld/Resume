package binauld.pierre.resume.listeners;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageButton;

public class LocationListener implements ImageButton.OnClickListener {

    private Context context;

    public LocationListener(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        String query = (String) v.getTag();
        Uri geo = Uri.parse("geo:0,0?q=" + query);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geo);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
