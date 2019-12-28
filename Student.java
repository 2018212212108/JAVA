/**
 * 学生类
 * 
 * @author HuYating
 *
 */
public class Student {
    private int id;//学号
    private String name;//姓名
    private int age;//年龄
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
        String eventsS="";//运动项目成绩字符串
        for(int i=0;i<Config.events.length;i++){
            //coursesS=courseAndScore[i].toString();
        	eventsS=eventsS+"\t "+sportAndScore[i].getSportName()+":"
                     +sportAndScore[i].getSportScore();
        }
        return "学号：" + id + "\t姓名：" + name + "\t年龄：" + age
                + " \t运动项目成绩："+eventsS;
    }
    public boolean equals(Student obj){
        if(obj.id==this.id&&obj.name.equals(this.name)){
            return true;
        }
        return false;

    }
}

