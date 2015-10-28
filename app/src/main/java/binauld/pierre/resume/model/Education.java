package binauld.pierre.resume.model;

public class Education {

    private int picture;
    private String school;
    private String field;

    public Education(int picture, String school, String field) {
        this.picture = picture;
        this.school = school;
        this.field = field;
    }

    public int getPicture() {
        return picture;
    }

    public String getSchool() {
        return school;
    }

    public String getField() {
        return field;
    }
}
