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
    private List<Education> educations = new ArrayList<>();

    public Account(Resources res) {

        firstName   = res.getString(R.string.first_name );
        lastName    = res.getString(R.string.last_name  );
        email       = res.getString(R.string.email      );

        pictureAccount  = R.drawable.account_picture;
        picturePanorama = R.drawable.account_panorama;

        Education education1 = new Education(
                R.drawable.polytech_lyon,
                "Polytech Lyon",
                "Polytech Lyon, 15 Boulevard André Latarget, 69100 Villeurbanne",
                "http://polytech.univ-lyon1.fr/",
                "IUT Annecy, Rue de l'Arc en Ciel, Annecy-le-Vieux");
        Education education2 = new Education(
                R.drawable.iut_annecy,
                "IUT Annecy",
                "IUT Annecy, Rue de l'Arc en Ciel, Annecy-le-Vieux",
                "https://www.iut-acy.univ-smb.fr/",
                "Studied Computer Science");

        educations.add(education1);
        educations.add(education2);

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

    public List<Education> getEducation() {
        return educations;
    }
}

