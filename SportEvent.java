/**
 * �˶���Ŀ��
 * 
 * @author HuYating
 * 
 */
public class SportEvent{
    private String sportName;// �˶���Ŀ����
    private float sportScore;// �˶���Ŀ�ɼ�

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
