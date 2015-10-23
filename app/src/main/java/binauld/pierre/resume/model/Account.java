package binauld.pierre.resume.model;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

import binauld.pierre.resume.R;

public class Account {

    private int pictureAccount;
    private int picturePanorama;
    private String firstName;
    private String lastName;
    private String email;
    private List<Category> categories = new ArrayList<>();

    public Account(Resources res) {

        firstName   = res.getString(R.string.first_name );
        lastName    = res.getString(R.string.last_name  );
        email       = res.getString(R.string.email      );

        pictureAccount  = R.drawable.account_picture;
        picturePanorama = R.drawable.account_panorama;

        Category education   = new Category(res.getString(R.string.account_category_education    ), R.drawable.ic_social_school);
        Category skills      = new Category(res.getString(R.string.account_category_skills       ), R.drawable.ic_social_school);
        Category techSkills  = new Category(res.getString(R.string.account_category_tech_skills  ), R.drawable.ic_action);
        Category experiences = new Category(res.getString(R.string.account_category_experiences  ), R.drawable.ic_social_school);
        Category misc        = new Category(res.getString(R.string.account_category_miscellaneous), R.drawable.ic_social_school);

        categories.add(education    );
        categories.add(skills       );
        categories.add(techSkills   );
        categories.add(experiences  );
        categories.add(misc         );
    }

    public List<Category> getCategories() {
        return categories;
    }

    public int getPictureAccount() {
        return pictureAccount;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public String getEmail() {
        return email;
    }

    public int getPicturePanorama() {
        return picturePanorama;
    }
}

