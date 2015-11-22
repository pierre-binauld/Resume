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
    private List<Experience> otherExperiences;
    private List<SkillCategory> skillCategories;

    public Account(Resources res) {

        firstName   = res.getString(R.string.first_name );
        lastName    = res.getString(R.string.last_name  );
        email       = res.getString(R.string.email      );

        pictureAccount  = R.drawable.account_picture;
        picturePanorama = R.drawable.account_panorama;

        educations       = Account.buildEducations();
        experiences      = Account.buildExperiences();
        skillCategories  = Account.buildSkillCategories();
        otherExperiences = Account.buildOtherExperiences();

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

    public List<SkillCategory> getSkillCategories() {
        return skillCategories;
    }

    public List<Experience> getOtherExperiences() {
        return otherExperiences;
    }

    private static List<Experience> buildOtherExperiences() {

        List<Experience> experiences = new ArrayList<>();

        Experience experience1 = new Experience(
                "Cashier (part time)",
                "Grand Frais",
                "Jul. 2011",
                "Aug. 2012",
                R.drawable.grand_frais
        );
        experience1.setLocation("Grand Frais, zone commerciale du Grand Epagny, Rue de la Mandallaz, 74330 Epagny");
        experience1.setWebPage("http://www.grandfrais.com/epagny/magasin-108.html");

        experiences.add(experience1);

        return experiences;
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

    private static List<SkillCategory> buildSkillCategories() {

        // --- --- --- -- -- -

        Skill linux     = new Skill("Linux",    R.drawable.linux,   4);
        Skill windows   = new Skill("Windows",  R.drawable.windows, 4);

        Skill eclipse       = new Skill("Eclipse",          R.drawable.eclipse,         4);
        Skill androidStudio = new Skill("Android Studio",   R.drawable.android_studio,  3);
        Skill git           = new Skill("Git",              R.drawable.git,             3);
        Skill svn           = new Skill("SVN",              R.drawable.svn,             3);
        Skill maven         = new Skill("Maven",            R.drawable.maven,           3);
        Skill jenkins       = new Skill("Jenkins",          R.drawable.jenkins,         2);
        Skill jira          = new Skill("Jira",             R.drawable.jira,            2);

        Skill sql       = new Skill("SQL",      R.drawable.sql,     4);
        Skill mysql     = new Skill("MySQL",    R.drawable.mysql,   4);
        Skill oracle    = new Skill("Oracle",   R.drawable.oracle,  2);

        Skill java       = new Skill("Java",         R.drawable.java,        4);
        Skill android    = new Skill("Android",      R.drawable.android,     3);
        Skill j2ee       = new Skill("J2EE",         R.drawable.j2ee,        3);
        Skill spring     = new Skill("Spring",       R.drawable.spring,      2);
        Skill hibernate  = new Skill("Hibernate",    R.drawable.hibernate,   2);
        Skill tapestry   = new Skill("Tapestry",     R.drawable.tapestry,    2);
        Skill junit      = new Skill("JUnit",        R.drawable.junit,       2);
        Skill cpp        = new Skill("C/C++",        R.drawable.cpp,         3);
        Skill xml        = new Skill("XML",          R.drawable.xml,         3);
        Skill rest       = new Skill("REST",         R.drawable.rest,        2);
        Skill soap       = new Skill("SOAP",         R.drawable.soap,        2);
        Skill json       = new Skill("JSON",         R.drawable.json,        2);
        Skill php        = new Skill("PHP",          R.drawable.php,         3);
        Skill zend       = new Skill("Zend",         R.drawable.zend,        2);
        Skill html       = new Skill("HTML",         R.drawable.html,        4);
        Skill css        = new Skill("CSS",         R.drawable.css,         3);
        Skill javascript = new Skill("Javascript",   R.drawable.javascript,  2);
        Skill jquery     = new Skill("JQuery",       R.drawable.jquery,      2);

        SkillCategory system = new SkillCategory("Operating System");
        system.add(linux);
        system.add(windows);

        SkillCategory software = new SkillCategory("Software");
        software.add(androidStudio);
        software.add(eclipse);
        software.add(git);
        software.add(svn);
        software.add(maven);
        software.add(jenkins);
        software.add(jira);

        SkillCategory db = new SkillCategory("Database");
        db.add(sql);
        db.add(mysql);
        db.add(oracle);

        SkillCategory web = new SkillCategory("Web Development");
        web.add(php);
        web.add(zend);
        web.add(html);
        web.add(css);
        web.add(javascript);
        web.add(jquery);
        web.add(xml);
        web.add(rest);
        web.add(soap);
        web.add(json);

        SkillCategory dev = new SkillCategory("Application Development");
        dev.add(java);
        dev.add(android);
        dev.add(j2ee);
        dev.add(spring);
        dev.add(hibernate);
        dev.add(tapestry);
        dev.add(junit);
        dev.add(cpp);

        List<SkillCategory> skillCategories = new ArrayList<>();
        skillCategories.add(dev);
        skillCategories.add(web);
        skillCategories.add(db);
        skillCategories.add(software);
        skillCategories.add(system);

        return skillCategories;
    }
}

