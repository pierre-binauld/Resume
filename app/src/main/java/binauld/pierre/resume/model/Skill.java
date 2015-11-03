package binauld.pierre.resume.model;

public class Skill {

    public static final int RANK_MIN = 0;
    public static final int RANK_MAX = 5;

    private int picture = 0;
    private String name;
    private int rank;

    public Skill(String name) {
        this.name = name;
    }

    public Skill(String name, int picture) {
        this.picture = picture;
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        if(rank > RANK_MAX) {
            this.rank = RANK_MAX;
        } else if (rank < RANK_MIN) {
            this.rank = RANK_MIN;
        } else {
            this.rank = rank;
        }
    }

    public int getPicture() {
        return picture;
    }

    public String getName() {
        return name;
    }
}
