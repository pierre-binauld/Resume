package binauld.pierre.resume.strategies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import binauld.pierre.resume.model.Account;

public interface MainActivityStrategy {

    AppCompatActivity getActivity();

    Account getAccount();

    void onCreate(Bundle savedInstanceState);
}
