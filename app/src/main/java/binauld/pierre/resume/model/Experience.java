package binauld.pierre.resume.model;


import java.util.ArrayList;
import java.util.List;

public class Experience {

    private int picture;
    private String position;
    private String company;
    private String webPage;
    private String location;
    private String start;
    private String end;
    private List<Skill> skills = new ArrayList<>();

    public Experience(String position, String company, String start, String end, int picture) {
        this.position = position;
        this.company = company;
        this.picture = picture;
        this.start = start;
        this.end = end;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPicture() {
        return picture;
    }

    public String getPosition() {
        return position;
    }

    public String getCompany() {
        return company;
    }

    public String getWebPage() {
        return webPage;
    }

    public String getLocation() {
        return location;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addTechnicalSkill(Skill skill) {
        skills.add(skill);
    }
}
