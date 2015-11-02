package binauld.pierre.resume.model;

public class Skill {

    private int picture = 0;
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public Skill(String name, int picture) {
        this.picture = picture;
        this.name = name;
    }

    public int getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }
}
