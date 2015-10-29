package binauld.pierre.resume.model;

public class Education {

    private int picture;
    private String school;
    private String place;
    private String webPage;
    private String field;

    public Education(int picture, String school, String place, String webPage, String field) {
        this.picture = picture;
        this.school  = school;
        this.place   = place;
        this.webPage = webPage;
        this.field   = field;
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

    public String getWebPage() {
        return webPage;
    }

    public String getPlace() {
        return place;
    }
}
