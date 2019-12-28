/**
 * ѧ����
 * 
 * @author HuYating
 *
 */
public class Student {
    private int id;//ѧ��
    private String name;//����
    private int age;//����
    private SportEvent sportAndScore[];

    public Student(){
        this.id=Config.idp;
        sportAndScore=new SportEvent[Config.events.length];
    }


    public SportEvent[] getSportAndScore() {
        return sportAndScore;
    }


    public void setSportAndScore(SportEvent[] sportAndScore) {
        this.sportAndScore = sportAndScore;
    }


    private void initSportAndScore() {
        // TODO Auto-generated method stub
        sportAndScore=new SportEvent[Config.events.length];
        for(int i=0;i<Config.events.length;i++){
        	sportAndScore[i]=new SportEvent(Config.events[i], 0);
        }   
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }


    public String toString() {
        String eventsS="";//�˶���Ŀ�ɼ��ַ���
        for(int i=0;i<Config.events.length;i++){
            //coursesS=courseAndScore[i].toString();
        	eventsS=eventsS+"\t "+sportAndScore[i].getSportName()+":"
                     +sportAndScore[i].getSportScore();
        }
        return "ѧ�ţ�" + id + "\t������" + name + "\t���䣺" + age
                + " \t�˶���Ŀ�ɼ���"+eventsS;
    }
    public boolean equals(Student obj){
        if(obj.id==this.id&&obj.name.equals(this.name)){
            return true;
        }
        return false;

    }
}

