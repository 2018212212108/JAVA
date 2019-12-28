import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ������
 * 
 * @author HuYating
 * 
 */
public class Func {
    private static final String FILE_NAME = "info.txt";// ������Ϣ���ļ�����

    public Func() {

    }

    /*
     * ��ϵͳ�����ı����Ҫ�����е�ѧ�����ݶ���գ��������ݻ���
     */
    public Student[] clear(Student[] sInfo) {
        File file = new File(FILE_NAME);
        if (file.isFile() && file.exists()) {
            file.delete();
        }
        return null;
    }

    /*
     * ����ѧ����Ϣ
     */
    public Student[] setStudentInfo() {
        Student[] sInfo = null;
        File file = new File(FILE_NAME);
        if (file.isFile() && file.exists()) {
            // Scanner sc = new Scanner(System.in);
            // System.out.println("��⵽�Ѵ���֮ǰ���ݵ��ļ����Ƿ���ļ������룿Y/N");
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
     * ����ļ�����
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
            System.out.println("�ѳɹ�����ѧ����Ϣ�ļ�");
            p.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("�ļ������쳣��δ�������ݣ�");
            e.printStackTrace();
        }
    }

    /*
     * �Ӽ�������
     */
    public Student[] addInputFromKeyboard(Student[] sInfos) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������Ҫ��ӵ�ѧ��������");
        int count = sc.nextInt();
        Student sInfo[];
        // Ӧ�Ե�һ�����ʱ���ļ�Ϊ�����
        if (sInfos != null)
            sInfo = new Student[count + sInfos.length];
        else
            sInfo = new Student[count];
        for (int i = 0; i < count; i++) {
            sInfo[i] = new Student();
            System.out.println("������ѧ��Ϊ " + (Config.idp++ ) + " ��ѧ��������");
            sInfo[i].setName(sc.next());
            System.out.println("������ " + sInfo[i].getName() + " ͬѧ�����䣺");
            boolean tage = false;// �ж������Ƿ�淶��־
            while (tage == false) {
                int age = sc.nextInt();
                if (age > 0) {
                    sInfo[i].setAge(age);
                    tage = true;
                } else {
                    System.err.println("��������ȷ�����䣡����");
                    System.out.println("���������� " + sInfo[i].getName()
                            + " ͬѧ�����䣺");
                }
            }
            SportEvent c[] = new SportEvent[Config.events.length];
            for (int j = 0; j < Config.events.length; j++) {
                System.out.println("������ " + sInfo[i].getName() + " ͬѧ�� "
                        + Config.events[j] + " �ɼ�");
                boolean tscore = false;// �жϳɼ��Ƿ�淶��־

                while (tscore == false) {
                    float score = sc.nextFloat();
                    if (score > 0 && score <= 100) {
                        c[j] = new SportEvent(Config.events[j], score);
                        tscore = true;
                    } else {
                        System.err.println("��������ȷ�ĳɼ�������");
                        System.out.println("���������� " + sInfo[i].getName()
                                + " ͬѧ�� " + Config.events[j] + " �ɼ�");
                    }
                }
                sInfo[i].setSportAndScore(c);
            }
        }
        // ����֮ǰ������Ԫ�ؽ�ȥ
        // �ǵ�һ����Ӳ���Ҫ����
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
     * ���ļ�������
     */
    public Student[] inputFromFile() {
        ArrayList<Student> sList = new ArrayList<Student>();// δ֪ѧ�������������ö�̬����洢
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
                    sList.add(s);// ���һ��ѧ����Ϣ
                }
                in.close();
                Student[] sInfo = (Student[]) sList.toArray(new Student[sList
                        .size()]);// �Ѷ�̬����ת������

                return sInfo;
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                System.err.println("���ļ�ʧ�ܣ�");
                e.printStackTrace();
            }
        }
        return null;
    }

    /*
     * ��ӡѧ����Ϣ sortFuncֵȱʡʱ�Ͱ���ѧ���������� sortFunc����ʾ����
     * ��ѧ�������������ʾ��{"xh","sx"}������Ϊ{"xh","jx"}
     * �����������������ʾ��{"nl","sx"}������Ϊ{"nl","jx"} ���γ̳ɼ������������ʾ��{"cj","sx","����"}
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
                int order = 0;// ��Ϊ��������ȥ��0ʱ����1ʱ����
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
                int order = 1;// Ĭ�ϳɼ��Ӹߵ�������Ҫ�ӵ͵�������orderֵ��0
                if (sortFunc[1].equals("sx"))
                    order = 0;
                sInfo = sortByCourseScore(sInfo, sortFunc[2], order);
            } else {
                System.err.println("δ�ҵ����򷽷�����������Ƿ���ȷ��");
            }
            for (int i = 0; i < sInfo.length; i++) {
                System.out.println(sInfo[i].toString());
            }
        } else
            System.out.println("�������κ�ѧ����Ϣ�����������Ϣ��");
    }

    /*
     * ����ѧ������ orderֵȱʡ�Ͱ�ѧ�Ŵ�С������������
     */
    private Student[] sortById(Student[] sInfo, int... order) {
        if ((order.length > 0 && order[0] == 0) || order.length < 1) {
            System.out.println("��ѧ�������������£�");
            // ��С��������
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
            System.out.println("��ѧ�Ž����������£�");
            // ��С��������
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
            System.err.println("���򷽷��в�������δ��ѧ�Ž�������");
        }
        return sInfo;
    }

    /*
     * ������������ orderȱʡ�Ͱ������С��������
     */
    private Student[] sortByAge(Student[] sInfo, int... order) {
        if ((order.length > 0 && order[0] == 0) || order.length < 1) {
            System.out.println("�����������������£�");
            // ��С��������
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
            System.out.println("�����併���������£�");
            // ��С��������
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
            System.out.println("���򷽷��в�������δ������������ݽ�������");
        }
        return sInfo;
    }

    /*
     * �����˶���Ŀ�ɼ����� orderȱʡ�Ͱ��ɼ��Ӹߵ�������
     */
    private Student[] sortByCourseScore(Student[] sInfo, String sportName,
            int... order) {
        int sportIndex = 0;// �˶���Ŀ��Ӧ�������±�
        for (; sportIndex < Config.events.length; sportIndex++) {
            if (sportName.equals(Config.events[sportIndex]))
                break;
        }
        // �ɼ��Ӹߵ�����
        if ((order.length > 0 && order[0] == 1) || order.length < 1) {
            System.out.println("���ɼ��Ӹߵ����������£�");
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
            System.out.println("���ɼ��ӵ͵����������£�");
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
     * ������ѧ����Ϣ
     */
    public Student[] serialPrint(Student sInfo[]) {
        if (sInfo != null) {
            // �Ȱ���ѧ�����������ź�
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
                System.out.println("��" + (i + 1) + "��\t    "
                        + sInfo[i].toString());
            }
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
        return sInfo;
    }

    /*
     * �޸�ѧ����Ϣ ����Ϊ��Ӧѧ����ţ���������ʵ�±꣩
     */
    public Student[] editSelectStudent(Student sInfo[], int index,
            int sportIndex, float sportScore) {
        if (sInfo != null) {
            sInfo[index].getSportAndScore()[sportIndex]
                    .setSportScore(sportScore);
            oupPuttoFile(sInfo);
            System.out.println("�޸ĳɹ�");
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
        return sInfo;
    }

    /*
     * ɾ��ѧ����Ϣ ����Ϊѧ����Ӧ��ţ���������ʵ�±꣩
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
            System.out.println("ɾ���ɹ�");
            return newSInfo;
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
        return null;
    }

    /*
     * ָ��ѧ�Ų�ѯѧ����Ϣ����ͨ��ѯ��
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
            System.out.println("��ѯ��" + count + "����¼");
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
    }

    /*
     * ָ��������ѯ������ͨ���ؼ��ֲ��ң�
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
            System.out.println("��ѯ��" + count + "����¼");
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
    }

    /*
     * ͳ�Ƹ�����ƽ����
     */
    public void getAverage(Student sInfo[]) {
        if (sInfo != null) {
            float sumScore = 0.0f;
            System.out.println("���˶���Ŀƽ��������");
            for (int i = 0; i < Config.events.length; i++) {
                sumScore = getOneCourseSum(sInfo, Config.events[i]);
                System.out.println(Config.events[i] + "��ƽ����Ϊ��" + sumScore
                        / sInfo.length);
            }
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
    }

    /*
     * �õ��ܷ�
     */
    public void getCourseSum(Student sInfo[]) {
        if (sInfo != null) {
            float sumScore = 0.0f;
            System.out.println("���˶���Ŀ�ܷ����£�");
            for (int i = 0; i < Config.events.length; i++) {
                sumScore = getOneCourseSum(sInfo, Config.events[i]);
                System.out.println(Config.events[i] + "���ܷ�Ϊ��" + sumScore);
            }
        } else
            System.err.println("�������κ�ѧ����Ϣ�����������Ϣ��");
    }

    /*
     * �õ�һ���ܷ�
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
