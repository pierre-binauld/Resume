package binauld.pierre.resume.model;


import java.util.ArrayList;

public class SkillCategory extends ArrayList<Skill> {

    private String name;

    public SkillCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
