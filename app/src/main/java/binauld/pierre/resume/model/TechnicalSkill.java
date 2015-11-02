package binauld.pierre.resume.model;

public class TechnicalSkill {

    private int picture = 0;
    private String name;

    public TechnicalSkill(String name) {
        this.name = name;
    }

    public TechnicalSkill(String name, int picture) {
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
