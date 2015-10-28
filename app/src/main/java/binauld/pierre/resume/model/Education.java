package binauld.pierre.resume.model;

public class Education {

    private int picture;
    private String school;
    private String place;
    private String webSite;
    private String field;

    public Education(int picture, String school, String place, String webSite, String field) {
        this.picture = picture;
        this.school  = school;
        this.place   = place;
        this.webSite = webSite;
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

    public String getWebSite() {
        return webSite;
    }

    public String getPlace() {
        return place;
    }
}
