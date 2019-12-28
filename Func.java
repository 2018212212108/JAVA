import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 方法类
 * 
 * @author HuYating
 * 
 */
public class Func {
    private static final String FILE_NAME = "info.txt";// 备份信息的文件名称

    public Func() {

    }

    /*
     * 当系统参数改变后，需要把所有的学生数据都清空，避免数据混淆
     */
    public Student[] clear(Student[] sInfo) {
        File file = new File(FILE_NAME);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
        return null;
    }

    /*
     * 设置学生信息
     */
    public Student[] setStudentInfo() {
        Student[] sInfo = null;
        File file = new File(FILE_NAME);
        if (file.isFile() && file.exists()) {
            // Scanner sc = new Scanner(System.in);
            // System.out.println("检测到已存在之前备份的文件，是否从文件中输入？Y/N");
            // String select = sc.next();
            // if (select.equals("Y") || select.equals("y")) {
            sInfo = inputFromFile();
            // } else {
            // sInfo = inputFromKeyboard();
            // }
            // sc.close();
        } else {

            // sInfo = inputFromKeyboard();
        }
        return sInfo;
    }

    /*
     * 输出文件备份
     */
    private void oupPuttoFile(Student[] sInfo) {
        // TODO Auto-generated method stub
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(new File(FILE_NAME));
            PrintStream p = new PrintStream(fs);
            for (int i = 0; i < sInfo.length; i++) {
                p.println(sInfo[i].getId());
                p.println(sInfo[i].getName());
                p.println(sInfo[i].getAge());
                for (int j = 0; j < sInfo[i].getSportAndScore().length; j++) {
                    p.println(sInfo[i].getSportAndScore()[j].getSportScore());
                }
            }
            System.out.println("已成功备份学生信息文件");
            p.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("文件操作异常，未备份数据！");
            e.printStackTrace();
        }
    }

    /*
     * 从键盘输入
     */
    public Student[] addInputFromKeyboard(Student[] sInfos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要添加的学生数量：");
        int count = sc.nextInt();
        Student sInfo[];
        // 应对第一次添加时，文件为空情况
        if (sInfos != null)
            sInfo = new Student[count + sInfos.length];
        else
            sInfo = new Student[count];
        for (int i = 0; i < count; i++) {
            sInfo[i] = new Student();
            System.out.println("请输入学号为 " + (Config.idp++ ) + " 的学生姓名：");
            sInfo[i].setName(sc.next());
            System.out.println("请输入 " + sInfo[i].getName() + " 同学的年龄：");
            boolean tage = false;// 判断年龄是否规范标志
            while (tage == false) {
                int age = sc.nextInt();
                if (age > 0) {
                    sInfo[i].setAge(age);
                    tage = true;
                } else {
                    System.err.println("请输入正确的年龄！！！");
                    System.out.println("请重新输入 " + sInfo[i].getName()
                            + " 同学的年龄：");
                }
            }
            SportEvent c[] = new SportEvent[Config.events.length];
            for (int j = 0; j < Config.events.length; j++) {
                System.out.println("请输入 " + sInfo[i].getName() + " 同学的 "
                        + Config.events[j] + " 成绩");
                boolean tscore = false;// 判断成绩是否规范标志

                while (tscore == false) {
                    float score = sc.nextFloat();
                    if (score > 0 && score <= 100) {
                        c[j] = new SportEvent(Config.events[j], score);
                        tscore = true;
                    } else {
                        System.err.println("请输入正确的成绩！！！");
                        System.out.println("请重新输入 " + sInfo[i].getName()
                                + " 同学的 " + Config.events[j] + " 成绩");
                    }
                }
                sInfo[i].setSportAndScore(c);
            }
        }
        // 复制之前的数组元素进去
        // 非第一次添加才需要链接
        if (sInfos != null) {
            for (int i = count; i < count + sInfos.length; i++) {
                sInfo[i] = new Student();
                sInfo[i] = sInfos[i - count];
            }
        }
        oupPuttoFile(sInfo);
        return sInfo;
    }

    /*
     * 从文件中输入
     */
    public Student[] inputFromFile() {
        ArrayList<Student> sList = new ArrayList<Student>();// 未知学生个数，所以用动态数组存储
        File f = new File(FILE_NAME);
        if (f.exists()) {
            try {
                Scanner in = new Scanner(new File(FILE_NAME));
                while (in.hasNextLine()) {
                    Student s = new Student();
                    int tempID = Integer.parseInt(in.nextLine());
                    if (tempID > Config.idp)
                    	Config.idp = tempID + 1;
                    s.setId(tempID);
                    s.setName(in.nextLine());
                    s.setAge(Integer.parseInt(in.nextLine()));
                    int i = 0;
                    SportEvent c[] = new SportEvent[Config.events.length];
                    for (String cname : Config.events) {
                        c[i++] = new SportEvent(cname, Float.parseFloat(in.nextLine()));
                    }
                    s.setSportAndScore(c);
                    sList.add(s);// 存进一个学生信息
                }
                in.close();
                Student[] sInfo = (Student[]) sList.toArray(new Student[sList
                        .size()]);// 把动态数组转成数组

                return sInfo;
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                System.err.println("打开文件失败！");
                e.printStackTrace();
            }
        }
        return null;
    }

    /*
     * 打印学生信息 sortFunc值缺省时就按照学号升序排序 sortFunc参数示例：
     * 按学号升序排序参数示例{"xh","sx"}，降序为{"xh","jx"}
     * 按年龄升序排序参数示例{"nl","sx"}，降序为{"nl","jx"} 按课程成绩升序排序参数示例{"cj","sx","语文"}
     */
    public void printStudentInfo(Student[] sInfo, String... sortFunc) {
        if (sInfo != null) {
            if (sortFunc.length < 1) {
                sInfo = sortById(sInfo);
            } else if (sortFunc.length == 1) {
                switch (sortFunc[0]) {
                case "xh":
                    sInfo = sortById(sInfo);
                    break;
                case "nl":
                    sInfo = sortByAge(sInfo);
                    break;
                }
            } else if (sortFunc.length == 2 && !sortFunc[0].equals("cj")) {
                int order = 0;// 作为参数传进去，0时升序，1时降序
                if (sortFunc[1].equals("jx"))
                    order = 1;
                switch (sortFunc[0]) {
                case "xh":
                    sInfo = sortById(sInfo, order);
                    break;
                case "nl":
                    sInfo = sortByAge(sInfo, order);
                    break;
                }
            } else if (sortFunc.length == 2 && sortFunc[0].equals("cj")) {
                sInfo = sortByCourseScore(sInfo, sortFunc[1]);
            } else if (sortFunc.length == 3) {
                int order = 1;// 默认成绩从高到低排序，要从低到高排序，order值传0
                if (sortFunc[1].equals("sx"))
                    order = 0;
                sInfo = sortByCourseScore(sInfo, sortFunc[2], order);
            } else {
                System.err.println("未找到排序方法，请检查参数是否正确！");
            }
            for (int i = 0; i < sInfo.length; i++) {
                System.out.println(sInfo[i].toString());
            }
        } else
            System.out.println("不存在任何学生信息，请先添加信息！");
    }

    /*
     * 按照学号排序 order值缺省就按学号从小到大排序（升序）
     */
    private Student[] sortById(Student[] sInfo, int... order) {
        if ((order.length > 0 && order[0] == 0) || order.length < 1) {
            System.out.println("按学号升序排序如下：");
            // 从小到达排序
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getId() > sInfo[j].getId()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }
        } else if (order.length > 0 && order[0] == 1) {
            System.out.println("按学号降序排序如下：");
            // 从小到达排序
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getId() < sInfo[j].getId()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }
        } else {
            System.err.println("排序方法中参数有误，未对学号进行排序");
        }
        return sInfo;
    }

    /*
     * 按照年龄排序 order缺省就按年龄从小到大排序
     */
    private Student[] sortByAge(Student[] sInfo, int... order) {
        if ((order.length > 0 && order[0] == 0) || order.length < 1) {
            System.out.println("按年龄升序排序如下：");
            // 从小到达排序
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getAge() > sInfo[j].getAge()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }
        } else if (order.length > 0 && order[0] == 1) {
            System.out.println("按年龄降序排序如下：");
            // 从小到达排序
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getAge() < sInfo[j].getAge()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }
        } else {
            System.out.println("排序方法中参数有误，未按照年龄对数据进行排序");
        }
        return sInfo;
    }

    /*
     * 按照运动项目成绩排序 order缺省就按成绩从高到低排序
     */
    private Student[] sortByCourseScore(Student[] sInfo, String sportName,
            int... order) {
        int sportIndex = 0;// 运动项目对应的数组下标
        for (; sportIndex < Config.events.length; sportIndex++) {
            if (sportName.equals(Config.events[sportIndex]))
                break;
        }
        // 成绩从高到低排
        if ((order.length > 0 && order[0] == 1) || order.length < 1) {
            System.out.println("按成绩从高到低排序如下：");
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getSportAndScore()[sportIndex]
                            .getSportScore() < sInfo[j].getSportAndScore()[sportIndex]
                            .getSportScore()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }
        } else if (order.length > 0 && order[0] == 0) {
            System.out.println("按成绩从低到高排序如下：");
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getSportAndScore()[sportIndex]
                            .getSportScore() > sInfo[j].getSportAndScore()[sportIndex]
                            .getSportScore()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }
        }
        return sInfo;
    }

    /*
     * 编号输出学生信息
     */
    public Student[] serialPrint(Student sInfo[]) {
        if (sInfo != null) {
            // 先按照学号升序排序排好
            for (int i = 0; i < sInfo.length - 1; i++) {
                for (int j = i + 1; j < sInfo.length; j++) {
                    if (sInfo[i].getId() > sInfo[j].getId()) {
                        Student temps = new Student();
                        temps = sInfo[i];
                        sInfo[i] = sInfo[j];
                        sInfo[j] = temps;
                    }
                }
            }

            for (int i = 0; i < sInfo.length; i++) {
                System.out.println("【" + (i + 1) + "】\t    "
                        + sInfo[i].toString());
            }
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
        return sInfo;
    }

    /*
     * 修改学生信息 参数为对应学生编号（数组中真实下标）
     */
    public Student[] editSelectStudent(Student sInfo[], int index,
            int sportIndex, float sportScore) {
        if (sInfo != null) {
            sInfo[index].getSportAndScore()[sportIndex]
                    .setSportScore(sportScore);
            oupPuttoFile(sInfo);
            System.out.println("修改成功");
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
        return sInfo;
    }

    /*
     * 删除学生信息 参数为学生对应编号（数组中真实下标）
     */
    public Student[] deleteSelectStudent(Student sInfo[], int index) {
        if (sInfo != null) {
            Student newSInfo[] = new Student[sInfo.length - 1];
            int i = 0, j = 0;
            for (; i < sInfo.length; i++) {
                if (index == i)
                    continue;
                newSInfo[j++] = sInfo[i];
            }
            oupPuttoFile(newSInfo);
            System.out.println("删除成功");
            return newSInfo;
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
        return null;
    }

    /*
     * 指定学号查询学生信息（普通查询）
     */
    public void searchById(Student sInfo[], int sId) {
        if (sInfo != null) {
            int count = 0;
            for (Student s : sInfo) {
                if (s.getId() == sId) {
                    System.out.println(s.toString());
                    count++;
                }
            }
            System.out.println("查询到" + count + "条记录");
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
    }

    /*
     * 指定姓名查询（可以通过关键字查找）
     */
    public void searchByName(Student sInfo[], String sName) {
        if (sInfo != null) {
            int count = 0;
            for (Student s : sInfo) {
                if (s.getName().indexOf(sName) >= 0) {
                    System.out.println(s.toString());
                    count++;
                }
            }
            System.out.println("查询到" + count + "条记录");
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
    }

    /*
     * 统计各科总平均分
     */
    public void getAverage(Student sInfo[]) {
        if (sInfo != null) {
            float sumScore = 0.0f;
            System.out.println("各运动项目平均分如下");
            for (int i = 0; i < Config.events.length; i++) {
                sumScore = getOneCourseSum(sInfo, Config.events[i]);
                System.out.println(Config.events[i] + "的平均分为：" + sumScore
                        / sInfo.length);
            }
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
    }

    /*
     * 得到总分
     */
    public void getCourseSum(Student sInfo[]) {
        if (sInfo != null) {
            float sumScore = 0.0f;
            System.out.println("各运动项目总分如下：");
            for (int i = 0; i < Config.events.length; i++) {
                sumScore = getOneCourseSum(sInfo, Config.events[i]);
                System.out.println(Config.events[i] + "的总分为：" + sumScore);
            }
        } else
            System.err.println("不存在任何学生信息，请先添加信息！");
    }

    /*
     * 得到一科总分
     */
    private float getOneCourseSum(Student sInfo[], String Sport) {
        float sumScore = 0.0f;
        for (int i = 0; i < Config.events.length; i++) {
            for (Student s : sInfo) {
                if (s.getSportAndScore()[i].getSportName().equals(Sport)) {
                    sumScore += s.getSportAndScore()[i].getSportScore();
                }
            }
        }
        return sumScore;
    }
}
