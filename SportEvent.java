/**
 * 运动项目类
 * 
 * @author HuYating
 * 
 */
public class SportEvent{
    private String sportName;// 运动项目名称
    private float sportScore;// 运动项目成绩

    public SportEvent(String sportName, float sportScore) {
        this.sportName = sportName;
        this.sportScore = sportScore;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public float getSportScore() {
        return sportScore;
    }

    public void setSportScore(float sportScore) {
        this.sportScore = sportScore;
    }

    public String toString() {
        return "Sport[sportName=" + sportName + ", sportScore="
                + sportScore + "]";
    }
}
