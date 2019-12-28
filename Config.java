import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ����ϵͳ����
 * 
 * @author HuYating
 *
 */
public class Config {
    private static final String CONFIG_FILE_NAME="config.txt";
    //���²�����ΪĬ�� ����
    public static int idp=1308095001;//idͳ�����������Զ�����id

    public static String events[]={"400m","800m","��Զ"};//�γ�

    public Config(){
        inputConfig();
    }
    /*
     * ������ʼѧ��
     */
    public void setIdp(){
        System.out.println("��������Ҫ���õ���ʼѧ�ţ�");
        Scanner sc=new Scanner(System.in);
        idp=sc.nextInt();
        System.out.println("���óɹ�");
    }
    /*
     * ���ÿγ�
     */
    public void setCourses(){
        System.out.println("��������Ҫ���õ��˶���Ŀ(��-1�������)��");
        Scanner sc=new Scanner(System.in);
        ArrayList<String> arr=new ArrayList<String>();
        String receiver="";
        while(sc.hasNext()&&!(receiver=sc.next()).equals("-1")){
            arr.add(receiver);
        }
        events=arr.toArray(new String[arr.size()]);
        System.out.println("���óɹ�");
    }


    /*
     * �������õĲ���
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
            System.err.println("�������������ʹ��Ĭ�ϲ���");
            e.printStackTrace();
        }
    }

    /*
     * �������õĲ���
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