package binauld.pierre.resume.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import binauld.pierre.resume.R;
import binauld.pierre.resume.view.transformations.CircleTransformation;

public class Chips extends LinearLayout {

    protected ImageView pictureView;

    protected TextView textView;

    private Transformation circleTransformation;

    public Chips(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Chips);
        String  text         = typedArray.getText(R.styleable.Chips_text).toString();
        int     pictureId    = typedArray.getResourceId(R.styleable.Chips_picture, 0);
        typedArray.recycle();

        init(context, text, pictureId);
    }

    public Chips(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Chips);
        String  text         = typedArray.getText(R.styleable.Chips_text).toString();
        int     pictureId    = typedArray.getResourceId(R.styleable.Chips_picture, 0);
        typedArray.recycle();

        init(context, text, pictureId);
    }

    private Chips(Context context, String text, int pictureId) {
        super(context);
        init(context, text, pictureId);
    }

    private void init(Context context, String text, int pictureId) {

        circleTransformation = new CircleTransformation();

        setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);

        if ( 0 == pictureId ) {
            inflate(context);

        } else {
            inflateWithPicture(context);

            initPicture(context, pictureId);
        }

        initText(text);

        setBackground(context.getResources().getDrawable(R.drawable.chips_background));

    }

    private void inflate(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chips, this, true);
    }

    private void inflateWithPicture(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chips_picture, this, true);
    }

    private void initText(String text) {
        textView = (TextView) this.findViewById(R.id.chips_text);
        textView.setText(text);
    }

    private void initPicture(Context context, int pictureId) {
        pictureView = (ImageView) this.findViewById(R.id.chips_picture);
        Picasso
                .with(context)
                .load(pictureId)
                .fit()
                .centerCrop()
                .transform(circleTransformation)
                .into(pictureView);
    }

    public static Chips getChips(Context context, String text, int pictureId) {
        return new Chips(context, text, pictureId);
    }

    public static Chips getChips(Context context, String text) {
        return new Chips(context, text, 0);
    }
}
