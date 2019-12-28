import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 处理系统参数
 * 
 * @author HuYating
 *
 */
public class Config {
    private static final String CONFIG_FILE_NAME="config.txt";
    //以下参数作为默认 参数
    public static int idp=1308095001;//id统计器，用于自动生成id

    public static String events[]={"400m","800m","跳远"};//课程

    public Config(){
        inputConfig();
    }
    /*
     * 设置起始学号
     */
    public void setIdp(){
        System.out.println("请输入您要设置的起始学号：");
        Scanner sc=new Scanner(System.in);
        idp=sc.nextInt();
        System.out.println("设置成功");
    }
    /*
     * 设置课程
     */
    public void setCourses(){
        System.out.println("请输入您要设置的运动项目(以-1完成输入)：");
        Scanner sc=new Scanner(System.in);
        ArrayList<String> arr=new ArrayList<String>();
        String receiver="";
        while(sc.hasNext()&&!(receiver=sc.next()).equals("-1")){
            arr.add(receiver);
        }
        events=arr.toArray(new String[arr.size()]);
        System.out.println("设置成功");
    }


    /*
     * 导入设置的参数
     */
    private void inputConfig(){
        File file = new File(CONFIG_FILE_NAME);
        if (!file.isFile() && !file.exists()) return;
        try {
            ArrayList<String> c=new ArrayList<String>();
            Scanner in = new Scanner(file);
            idp=Integer.parseInt(in.nextLine());
            while (in.hasNextLine()) {
                c.add(in.nextLine());
            }
            events=c.toArray(new String[c.size()]);
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.err.println("导入参数出错，将使用默认参数");
            e.printStackTrace();
        }
    }

    /*
     * 导出设置的参数
     */
    public void outputConfig(){
        FileOutputStream fs = null;
        try {
            fs = new FileOutputStream(new File(CONFIG_FILE_NAME));
            PrintStream p = new PrintStream(fs);
            p.println(idp);
            for(String c1:events)p.println(c1);
            p.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}