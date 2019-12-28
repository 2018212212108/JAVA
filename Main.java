import java.util.Scanner;

/**
 * 主菜单
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
        cf = new Config();// 实例化对象同时导入保存的参数
        ids=Config.idp;
        sInfo = f.inputFromFile();// 导入之前的数据
        m.menuMain();

        // Student sInfo[]=f.setStudentInfo();

        // f.printStudentInfo(sInfo,"xh","jx");
        // f.printStudentInfo(sInfo,"xh","sx");
        // f.printStudentInfo(sInfo);
        // f.printStudentInfo(sInfo,"xh");
        // f.printStudentInfo(sInfo,"nl");
    }

    /*
     * 主菜单
     */
    private void menuMain() {
        boolean canInput = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************");
		System.out.println("                               ");
		System.out.println("           欢迎使用运动会成绩管理系统！");
		System.out.println("                               ");
		System.out.println("*******************************");
		System.out.println("                               ");
		System.out.println("请选择登录身份：1.学院管理员    2.系统管理员");
		Scanner select = new Scanner(System.in);
		int num = select.nextInt();
		while(true) {
			
			switch(num) {
				case 1:
					System.out.println("当前登录身份：学院管理员");
					System.out.println("您的用户名：hyt"); 
					System.out.println("您的初始密码：123456");
					break;
				case 2:
					System.out.println("当前登录身份：系统管理员");
					System.out.println("您的用户名：zmt"); 
					System.out.println("您的初始密码：123456");
					break;
				default:
					System.err.println("暂未设置此身份请重新输入!");
					continue;
				}
			break;
		}
        while (num == 1) {
        	System.out.println("                               ");
            System.out.println("-------------------------------");
            System.out.println("请选择您所需要的操作：");
            System.out.println("          1、录入运动员信息");
            System.out.println("          2、查询运动员信息");
            System.out.println("          3、修改运动员信息");
            System.out.println("          4、删除运动员信息");
            System.out.println("          5、统计运动员数据");
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
                System.err.println("请输入正确的数字！");
                break;
            }
        }
        //sc.close();
        while (num == 2) {
        	System.out.println("                               ");
            System.out.println("-------------------------------");
            System.out.println("请选择您所需要的操作：                                       ");
            System.out.println("           0、修改系统参数");
            System.out.println("-------------------------------");
            switch (sc.next()) {
            case "0":
                menu0();
                break;
            default:
                System.err.println("请输入正确的数字！");
                break;
            }
        }
        //sc.close();
    }
    

    /*
     * 统计学生信息
     */
    private void menu5() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("请选择统计方式：");
        System.out.println("1、统计各运动项目成绩总平均分");
        System.out.println("2、统计各运动项目成绩总分");
        System.out.println("如果不进行以上操作请输入任意指令之外的数字退出本功能");
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
     * 设置系统参数菜单
     */
    private void menu0() {
        // TODO Auto-generated method stub
    	Config cf = new Config();
        Func f = new Func();
        Scanner sc = new Scanner(System.in);
        System.out.println("当前系统参数：");
        System.out.println("学号起始值：" + ids);
        System.out.print("当前运动项目：");
        for (String c : Config.events)
            System.out.print(c + " ");
        System.out.println();
        System.out.println("1、修改学号起始值");
        System.out.println("2、修改运动项目信息");
        System.out.println("不做修改请输入任意值返回主菜单");
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
     * 删除学生信息菜单
     */
    private void menu4() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("现有学生如下：");
        sInfo = f.serialPrint(sInfo);
        System.out.println("请输入要删除的学生对应的编号：");
        Scanner sc = new Scanner(System.in);
        sInfo = f.deleteSelectStudent(sInfo, sc.nextInt() - 1);
    }

    /*
     * 修改学生信息菜单 注：未做非法输入判断
     */
    private void menu3() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("现有学生如下：");
        sInfo = f.serialPrint(sInfo);
        System.out.println("请输入要修改的学生对应的编号（只允许修改运动项目成绩）：");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        System.out.println("请输入要修改的运动项目成绩对应编号：");
        int j = 1;
        for (String c : Config.events)
            System.out.print((j++) + "、" + c + "  ");
        System.out.println();
        int courseIndex = sc.nextInt();
        System.out.println("请输入【" + Config.events[courseIndex - 1]
                + "】修改后的成绩：");
        float courseScore = sc.nextFloat();
        f.editSelectStudent(sInfo, index - 1, courseIndex - 1, courseScore);
    }

    /*
     * 查询学生信息菜单
     */
    private void menu2() {
        // TODO Auto-generated method stub
        Func f = new Func();
        System.out.println("请选择查询方式：");
        System.out.println("1、按学号升序排序输出所有信息");
        System.out.println("2、按学号降序排序输出所有信息");
        System.out.println("3、按年龄升序排序输出所有信息");
        System.out.println("4、按年龄降序排序输出所有信息");
        System.out.println("5、按某运动项目成绩从低到高排序输出所有信息");
        System.out.println("6、按某运动项目成绩高到低排序输出所有信息");
        System.out.println("7、按学号查询学生信息");
        System.out.println("8、按姓名查询学生信息（支持关键字查找）");
        System.out.println("如果不进行以上操作请输入任意指令之外的数字退出本功能");
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
            System.out.println("请指定一个运动项目进行排序：");
            int i = 1;
            for (String c : Config.events)
                System.out.print((i++) + "、" + c + "  ");
            System.out.println();
            f.printStudentInfo(sInfo, "cj", "sx",
            		Config.events[sc.nextInt() - 1]);
            break;
        case "6":
            System.out.println("请指定一个运动项目进行排序：");
            int j = 1;
            for (String c : Config.events)
                System.out.print((j++) + "、" + c + "  ");
            System.out.println();
            f.printStudentInfo(sInfo, "cj", "jx",
            		Config.events[sc.nextInt() - 1]);
            break;
        case "7":
            System.out.println("请输入要查询的学号：");
            f.searchById(sInfo, sc.nextInt());
            break;
        case "8":
            System.out.println("请输入要查询的姓名：");
            f.searchByName(sInfo, sc.next());
            break;
        default:
            return;
        }
    }

    /*
     * 录入学生信息菜单
     */
    private void menu1() {
        // TODO Auto-generated method stub
        Func f = new Func();
        sInfo = f.addInputFromKeyboard(sInfo);
    }
}

