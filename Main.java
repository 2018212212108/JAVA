import java.util.Scanner;

/**
 * ���˵�
 * 
 * @author HuYating
 * 
 */
public class Main {
    static Config cf;
    static Student sInfo[];
    private static int ids;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Func f = new Func();
        Main m = new Main();
        cf = new Config();// ʵ��������ͬʱ���뱣��Ĳ���
        ids=Config.idp;
        sInfo = f.inputFromFile();// ����֮ǰ������
        m.menuMain();

        // Student sInfo[]=f.setStudentInfo();

        // f.printStudentInfo(sInfo,"xh","jx");
        // f.printStudentInfo(sInfo,"xh","sx");
        // f.printStudentInfo(sInfo);
        // f.printStudentInfo(sInfo,"xh");
        // f.printStudentInfo(sInfo,"nl");
    }

    /*
     * ���˵�
     */
    private void menuMain() {
        boolean canInput = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************");
		System.out.println("                               ");
		System.out.println("           ��ӭʹ���˶���ɼ�����ϵͳ��");
		System.out.println("                               ");
		System.out.println("*******************************");
		System.out.println("                               ");
		System.out.println("��ѡ���¼��ݣ�1.ѧԺ����Ա    2.ϵͳ����Ա");
		Scanner select = new Scanner(System.in);
		int num = select.nextInt();
		while(true) {
			
			switch(num) {
				case 1:
					System.out.println("��ǰ��¼��ݣ�ѧԺ����Ա");
					System.out.println("�����û�����hyt"); 
					System.out.println("���ĳ�ʼ���룺123456");
					break;
				case 2:
					System.out.println("��ǰ��¼��ݣ�ϵͳ����Ա");
					System.out.println("�����û�����zmt"); 
					System.out.println("���ĳ�ʼ���룺123456");
					break;
				default:
					System.err.println("��δ���ô��������������!");
					continue;
				}
			break;
		}
        while (num == 1) {
        	System.out.println("                               ");
            System.out.println("-------------------------------");
            System.out.println("��ѡ��������Ҫ�Ĳ�����");
            System.out.println("          1��¼���˶�Ա��Ϣ");
            System.out.println("          2����ѯ�˶�Ա��Ϣ");
            System.out.println("          3���޸��˶�Ա��Ϣ");
            System.out.println("          4��ɾ���˶�Ա��Ϣ");
            System.out.println("          5��ͳ���˶�Ա����");
            System.out.println("-------------------------------");
            switch (sc.next()) {
            case "1":
                menu1();
                break;
            case "2":
                menu2();
                break;
            case "3":
                menu3();
                break;
            case "4":
                menu4();
                break;
            case "5":
                menu5();
                break;
            default:
                System.err.println("��������ȷ�����֣�");
                break;
            }
        }
        //sc.close();
        while (num == 2) {
        	System.out.println("                               ");
            System.out.println("-------------------------------");
            System.out.println("��ѡ��������Ҫ�Ĳ�����                                       ");
            System.out.println("           0���޸�ϵͳ����");
            System.out.println("-------------------------------");
            switch (sc.next()) {
            case "0":
                menu0();
                break;
            default:
                System.err.println("��������ȷ�����֣�");
                break;
            }
        }
        //sc.close();
    }
    

    /*
     * ͳ��ѧ����Ϣ
     */
    private void menu5() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("��ѡ��ͳ�Ʒ�ʽ��");
        System.out.println("1��ͳ�Ƹ��˶���Ŀ�ɼ���ƽ����");
        System.out.println("2��ͳ�Ƹ��˶���Ŀ�ɼ��ܷ�");
        System.out.println("������������ϲ�������������ָ��֮��������˳�������");
        Scanner sc = new Scanner(System.in);
        switch (sc.next()) {
        case "1":
            f.getAverage(sInfo);
            break;
        case "2":
            f.getCourseSum(sInfo);
            break;
        default:
            return;
        }
    }

    /*
     * ����ϵͳ�����˵�
     */
    private void menu0() {
        // TODO Auto-generated method stub
    	Config cf = new Config();
        Func f = new Func();
        Scanner sc = new Scanner(System.in);
        System.out.println("��ǰϵͳ������");
        System.out.println("ѧ����ʼֵ��" + ids);
        System.out.print("��ǰ�˶���Ŀ��");
        for (String c : Config.events)
            System.out.print(c + " ");
        System.out.println();
        System.out.println("1���޸�ѧ����ʼֵ");
        System.out.println("2���޸��˶���Ŀ��Ϣ");
        System.out.println("�����޸�����������ֵ�������˵�");
        switch (sc.next()) {
        case "1":
            cf.setIdp();
            cf.outputConfig();
            ids=Config.idp;
            sInfo = f.clear(sInfo);
            break;
        case "2":
            cf.setCourses();
            cf.outputConfig();
            sInfo = f.clear(sInfo);
            break;
        default:
            return;
        }
    }

    /*
     * ɾ��ѧ����Ϣ�˵�
     */
    private void menu4() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("����ѧ�����£�");
        sInfo = f.serialPrint(sInfo);
        System.out.println("������Ҫɾ����ѧ����Ӧ�ı�ţ�");
        Scanner sc = new Scanner(System.in);
        sInfo = f.deleteSelectStudent(sInfo, sc.nextInt() - 1);
    }

    /*
     * �޸�ѧ����Ϣ�˵� ע��δ���Ƿ������ж�
     */
    private void menu3() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("����ѧ�����£�");
        sInfo = f.serialPrint(sInfo);
        System.out.println("������Ҫ�޸ĵ�ѧ����Ӧ�ı�ţ�ֻ�����޸��˶���Ŀ�ɼ�����");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        System.out.println("������Ҫ�޸ĵ��˶���Ŀ�ɼ���Ӧ��ţ�");
        int j = 1;
        for (String c : Config.events)
            System.out.print((j++) + "��" + c + "  ");
        System.out.println();
        int courseIndex = sc.nextInt();
        System.out.println("�����롾" + Config.events[courseIndex - 1]
                + "���޸ĺ�ĳɼ���");
        float courseScore = sc.nextFloat();
        f.editSelectStudent(sInfo, index - 1, courseIndex - 1, courseScore);
    }

    /*
     * ��ѯѧ����Ϣ�˵�
     */
    private void menu2() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("��ѡ���ѯ��ʽ��");
        System.out.println("1����ѧ�������������������Ϣ");
        System.out.println("2����ѧ�Ž����������������Ϣ");
        System.out.println("3�������������������������Ϣ");
        System.out.println("4�������併���������������Ϣ");
        System.out.println("5����ĳ�˶���Ŀ�ɼ��ӵ͵����������������Ϣ");
        System.out.println("6����ĳ�˶���Ŀ�ɼ��ߵ����������������Ϣ");
        System.out.println("7����ѧ�Ų�ѯѧ����Ϣ");
        System.out.println("8����������ѯѧ����Ϣ��֧�ֹؼ��ֲ��ң�");
        System.out.println("������������ϲ�������������ָ��֮��������˳�������");
        Scanner sc = new Scanner(System.in);
        switch (sc.next()) {
        case "1":
            f.printStudentInfo(sInfo, "xh");
            break;
        case "2":
            f.printStudentInfo(sInfo, "xh", "jx");
            break;
        case "3":
            f.printStudentInfo(sInfo, "nl");
            break;
        case "4":
            f.printStudentInfo(sInfo, "nl", "jx");
            break;
        case "5":
            System.out.println("��ָ��һ���˶���Ŀ��������");
            int i = 1;
            for (String c : Config.events)
                System.out.print((i++) + "��" + c + "  ");
            System.out.println();
            f.printStudentInfo(sInfo, "cj", "sx",
            		Config.events[sc.nextInt() - 1]);
            break;
        case "6":
            System.out.println("��ָ��һ���˶���Ŀ��������");
            int j = 1;
            for (String c : Config.events)
                System.out.print((j++) + "��" + c + "  ");
            System.out.println();
            f.printStudentInfo(sInfo, "cj", "jx",
            		Config.events[sc.nextInt() - 1]);
            break;
        case "7":
            System.out.println("������Ҫ��ѯ��ѧ�ţ�");
            f.searchById(sInfo, sc.nextInt());
            break;
        case "8":
            System.out.println("������Ҫ��ѯ��������");
            f.searchByName(sInfo, sc.next());
            break;
        default:
            return;
        }
    }

    /*
     * ¼��ѧ����Ϣ�˵�
     */
    private void menu1() {
        // TODO Auto-generated method stub
        Func f = new Func();
        sInfo = f.addInputFromKeyboard(sInfo);
    }
}

