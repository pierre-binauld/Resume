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
    private List<Education> educations;
    private List<Experience> experiences;
    private List<Skill> skills;

    public Account(Resources res) {

        firstName   = res.getString(R.string.first_name );
        lastName    = res.getString(R.string.last_name  );
        email       = res.getString(R.string.email      );

        pictureAccount  = R.drawable.account_picture;
        picturePanorama = R.drawable.account_panorama;

        educations  = Account.buildEducations();
        experiences = Account.buildExperiences();
        skills      = Account.buildSkills();
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

    public List<Education> getEducations() {
        return educations;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    private static List<Experience> buildExperiences() {

        List<Experience> experiences = new ArrayList<>();

        Experience experience1 = new Experience(
                "Intern as J2E developer",
                "Micropole",
                "Mar. 2015",
                "Sep. 2015",
                R.drawable.micropole
        );
        experience1.setLocation("Micropole Rhone Alpes, 4 Place Charles Hernu, 69100 Villeurbanne");
        experience1.setWebPage("http://www.micropole.com/");
        experience1.addTechnicalSkill(new Skill("Liferay", R.drawable.liferay));
        experience1.addTechnicalSkill(new Skill("Java", R.drawable.java));
        experience1.addTechnicalSkill(new Skill("Javascript", R.drawable.javascript));
        experience1.addTechnicalSkill(new Skill("SQL"));
        experience1.addTechnicalSkill(new Skill("Git", R.drawable.git));
        experience1.addTechnicalSkill(new Skill("Eclipse", R.drawable.eclipse));

        Experience experience2 = new Experience(
                "Intern as J2E developer",
                "ATOS Worldline",
                "Sep. 2013",
                "Jan. 2014",
                R.drawable.worldline
        );
        experience2.setLocation("Atrium Lyon Part Dieu 107-109 boulevard Vivier Merle 69438 LYON CEDEX 03");
        experience2.setWebPage("http://worldline.com/");
        experience2.addTechnicalSkill(new Skill("J2EE", R.drawable.j2ee));
        experience2.addTechnicalSkill(new Skill("Spring", R.drawable.spring));
        experience2.addTechnicalSkill(new Skill("Hibernate", R.drawable.hibernate));
        experience2.addTechnicalSkill(new Skill("Tapestry", R.drawable.tapestry));
        experience2.addTechnicalSkill(new Skill("Javascript", R.drawable.javascript));
        experience2.addTechnicalSkill(new Skill("JUnit"));
        experience2.addTechnicalSkill(new Skill("SQL"));
        experience2.addTechnicalSkill(new Skill("Jenkins", R.drawable.jenkins));
        experience2.addTechnicalSkill(new Skill("Git", R.drawable.git));

        Experience experience3 = new Experience(
                "Intern as Web developer",
                "NTN-SNR",
                "Apr. 2012",
                "Jun. 2012",
                R.drawable.snr
        );
        experience3.setLocation("NTN-SNR ROULEMENTS, 1 Rue des Usines, 74010 Annecy Cedex");
        experience3.setWebPage("http://www.ntn-snr.com/");
        experience3.addTechnicalSkill(new Skill("PHP", R.drawable.php));
        experience3.addTechnicalSkill(new Skill("Zend Framework", R.drawable.zend));
        experience3.addTechnicalSkill(new Skill("Javascript", R.drawable.javascript));
        experience3.addTechnicalSkill(new Skill("SQL"));

        experiences.add(experience1);
        experiences.add(experience2);
        experiences.add(experience3);

        return experiences;
    }

    private static List<Education> buildEducations() {

        List<Education> educations = new ArrayList<>();

        Education education1 = new Education(
                R.drawable.polytech_lyon,
                "Polytech Lyon",
                "Studied Computer Science",
                "2012",
                "2015");
        education1.setWebPage("http://polytech.univ-lyon1.fr/");
        education1.setLocation("Polytech Lyon, 15 Boulevard André Latarget, 69100 Villeurbanne");

        Education education2 = new Education(
                R.drawable.iut_annecy,
                "IUT Annecy",
                "Studied Computer Science",
                "2010",
                "2012");
        education1.setWebPage("https://www.iut-acy.univ-smb.fr/");
        education1.setLocation("IUT Annecy, Rue de l'Arc en Ciel, Annecy-le-Vieux");

        Education education3 = new Education(
                R.drawable.lycee_louis_lachenal,
                "Lycée Louis Lachenal",
                "Scientist baccalaureate diploma with honours",
                "2007",
                "2010");
        education1.setWebPage("http://www.lycee-louis-lachenal.fr/");
        education1.setLocation("School Louis Lachenal, 335 Route de Champ Farcon, 74370 Argonay");

        educations.add(education1);
        educations.add(education2);
        educations.add(education3);

        return educations;
    }

    private static List<Skill> buildSkills() {
        List<Skill> skills = new ArrayList<>();

        Skill linux = new Skill("Linux", R.drawable.linux);
        linux.setRank(4);
        skills.add(linux);

        Skill windows = new Skill("Windows", R.drawable.windows);
        windows.setRank(4);
        skills.add(windows);

        Skill eclipse = new Skill("Eclipse", R.drawable.eclipse);
        eclipse.setRank(4);
        skills.add(eclipse);

        Skill androidStudio = new Skill("Android Studio", R.drawable.android_studio);
        androidStudio.setRank(3);
        skills.add(androidStudio);

        Skill git = new Skill("Git", R.drawable.git);
        git.setRank(3);
        skills.add(git);

        Skill svn = new Skill("SVN", R.drawable.svn);
        svn.setRank(3);
        skills.add(svn);

        Skill maven = new Skill("Maven", R.drawable.maven);
        maven.setRank(3);
        skills.add(maven);

        Skill jenkins = new Skill("Jenkins", R.drawable.jenkins);
        jenkins.setRank(2);
        skills.add(jenkins);

        Skill jira = new Skill("Jira", R.drawable.jira);
        jira.setRank(2);
        skills.add(jira);

        Skill mysql = new Skill("MySQL", R.drawable.mysql);
        mysql.setRank(4);
        skills.add(mysql);

        Skill oracle = new Skill("Oracle", R.drawable.oracle);
        oracle.setRank(2);
        skills.add(oracle);

        Skill java = new Skill("Java", R.drawable.java);
        java.setRank(4);
        skills.add(java);

        Skill android = new Skill("Android", R.drawable.android);
        android.setRank(3);
        skills.add(android);

        Skill j2ee = new Skill("J2EE", R.drawable.j2ee);
        j2ee.setRank(3);
        skills.add(j2ee);

        Skill spring = new Skill("Spring", R.drawable.spring);
        spring.setRank(2);
        skills.add(spring);

        Skill hibernate = new Skill("Hibernate", R.drawable.hibernate);
        hibernate.setRank(2);
        skills.add(hibernate);

        Skill tapestry = new Skill("Tapestry", R.drawable.tapestry);
        tapestry.setRank(2);
        skills.add(tapestry);

        Skill junit = new Skill("JUnit", R.drawable.junit);
        junit.setRank(2);
        skills.add(junit);

        Skill cpp = new Skill("C/C++", R.drawable.cpp);
        cpp.setRank(3);
        skills.add(cpp);

        Skill sql = new Skill("SQL", R.drawable.sql);
        sql.setRank(4);
        skills.add(sql);

        Skill xml = new Skill("XML", R.drawable.xml);
        xml.setRank(3);
        skills.add(xml);

        Skill rest = new Skill("REST", R.drawable.rest);
        rest.setRank(2);
        skills.add(rest);

        Skill soap = new Skill("SOAP", R.drawable.soap);
        soap.setRank(2);
        skills.add(soap);

        Skill json = new Skill("JSON", R.drawable.json);
        json.setRank(2);
        skills.add(json);

        Skill php = new Skill("PHP", R.drawable.php);
        php.setRank(3);
        skills.add(php);

        Skill zend = new Skill("Zend", R.drawable.zend);
        zend.setRank(2);
        skills.add(zend);

        Skill html = new Skill("HTML", R.drawable.html);
        html.setRank(4);
        skills.add(html);

        Skill css = new Skill("HTML", R.drawable.css);
        css.setRank(3);
        skills.add(css);

        Skill javascript = new Skill("Javascript", R.drawable.javascript);
        javascript.setRank(2);
        skills.add(javascript);

        Skill jquery = new Skill("JQuery", R.drawable.jquery);
        jquery.setRank(2);
        skills.add(jquery);

        return skills;
    }
}

