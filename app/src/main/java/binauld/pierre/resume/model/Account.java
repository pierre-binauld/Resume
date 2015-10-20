package binauld.pierre.resume.model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import binauld.pierre.resume.R;

public class Account {

    List<String> categories = new ArrayList<>();

    public Account(Resources res) {
        categories.add(res.getString(R.string.account_category_education));
        categories.add(res.getString(R.string.account_category_skills));
    }

    public List<String> getCategories() {
        return categories;
    }
}

