package binauld.pierre.resume.strategies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public interface MainActivityStrategy {

    AppCompatActivity getActivity();

    void onCreate(Bundle savedInstanceState);
}
