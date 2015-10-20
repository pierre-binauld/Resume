package binauld.pierre.resume.model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import binauld.pierre.resume.R;

public class Account {

    List<Category> categories = new ArrayList<>();

    public Account(Resources res) {

        Category education  = new Category(res.getString(R.string.account_category_education), null);
        Category skills     = new Category(res.getString(R.string.account_category_skills), null);

        categories.add(education);
        categories.add(skills);
    }

    public List<Category> getCategories() {
        return categories;
    }
}

