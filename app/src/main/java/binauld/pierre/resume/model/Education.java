package binauld.pierre.resume.model;

public class Education {

    private int picture;
    private String school;
    private String location;
    private String webPage;
    private String field;
    private String start;
    private String end;

    public Education(int picture, String school, String field, String start, String end) {
        this.picture = picture;
        this.school  = school;
        this.field   = field;
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

    public String getSchool() {
        return school;
    }

    public String getField() {
        return field;
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
}
