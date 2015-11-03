package binauld.pierre.resume.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class PicassoLoaderTask extends AsyncTask<Void, Void, Void> {

    private RequestCreator creator;

    private Context context;
    private int picture;
    private ImageView imageView;

    public PicassoLoaderTask(Context context, int picture, ImageView imageView) {
        this.context = context;
        this.picture = picture;
        this.imageView = imageView;
    }

    @Override
    protected Void doInBackground(Void... params) {
        creator = Picasso
                .with(context)
                .load(picture)
                .fit()
                .centerCrop();

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        creator.into(imageView);
    }
}
