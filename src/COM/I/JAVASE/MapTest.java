package COM.I.JAVASE;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

/**
 * 使用Map对学生类的增删改查
 */
public class MapTest {

    /**
     * 用来承装学生类型对象
     * Map<key,value>
     * @param args
     */
    public Map<String,Student> students;

    /**
     * 添加构造方法
     * 在构造器中初始化students属性
     * @param args
     */
    public MapTest(){
        this.students = new HashMap<String, Student>();
    }

    /**
     * 测试添加:输入学生ID，判断是否被占用
     * 若魏碑占用,则输入姓名，创建新学生对象，
     * 并且添加到students中
     * @param args
     */
    public void testPut(){
        //创建一个Scanner对象,用来获取输入的学生ID和姓名
        Scanner console = new Scanner(System.in);
        int i = 0;
        while (i<3){
            System.out.println("请输入学生ID:");
            String ID = console.next();
            //判断该ID是否已被占用
            Student st = students.get(ID);
            if(st == null){
                //提示输入学生姓名
                System.out.println("请输入学生姓名");
                String name = console.next();

                //创建新的学生对象
                Student newStudent = new Student(ID,name);

                //通过调用students的·put方法，添加ID-学生映射
                students.put(ID,newStudent);
                System.out.println("成功添加学生"+students.get(ID).name);
                i++;
            }else{
                System.out.println("该学生ID已被占用！");
                continue;
            }
        }
    }

    /**
     * 测试Map的keySet方法
     * @param args
     */
    public void testKeySet(){
        //通过KeySet方法，返回Map中的所有"键"的set集合
        Set<String> studentsKeySet = students.keySet();
        //取得stuents的容量
        System.out.println("总共有学生："+students.size());

        //遍历KeySet,取得每一个键,再调用get方法取得每个键对应的value
        for (String stuId : studentsKeySet) {
            Student st = students.get(stuId);
            if (st != null){
                System.out.println("学生:"+st.name);
            }
        }
    }

    /**
     * 通过entrySet方法来遍历Map
     * @param args
     */
    public void testEntrySet(){
        //通过entrySet方法,返回Map中的所有键值对
        Set<Entry<String, Student>> entrySet = students.entrySet();
        for (Entry<String, Student> entry:entrySet){
            System.out.println("取得键:"+entry.getKey());
            System.out.println("对应的值为:"+entry.getValue().name);
            }
    }

    /**
     * 测试删除Map中的映射
     * @param args
     */
    public void testRemove(){
        Scanner console = new Scanner(System.in);

        while(true){
            System.out.println("请输入要删除的学生ID");
            //获取从键盘输入的待删除的学生ID
            String ID = console.next();

            //判定该ID是否有对应的学生对象
            Student st = students.get(ID);
            if (st == null){
                //提示ID情况(此处为不存在)
                System.out.println("该ID不存在");
                continue;
            }
            students.remove(ID);
            System.out.println("成功删除学生"+st.name);
            break;

        }
    }

    /**
     * 利用put方法修改Map中的已有映射
     * @param args
     */
    public void testModify(){
        System.out.println("请输入要修改的学生ID");

        //创建一个Scanner对象，获取键盘上输入的学生ID字符串
        Scanner console = new Scanner(System.in);
        while(true){
            //取得键盘上输入的学生ID
            String stuID = console.next();

            //从students中查找是否有相应的映射(该学生ID对应的学生对象)
            Student student = students.get(stuID);
            if (stuID == null){
                System.out.println("该ID不存在");
                continue;
            }

            //提示当前对应的学生对象的姓名
            System.out.println("该ID下的学生"+student.name+"将修改改为?");
            //取得键盘上输入的学生name
            String stuName = console.next();
            Student newStudent = new Student(stuID,stuName);
            //添加入students的map中
            students.put(stuID,newStudent);

            System.out.println(student.name+"成功修改为:"+students.get(stuID).name);

            //别忘记跳出循环!!!
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mp = new MapTest();
        mp.testPut();
        mp.testKeySet();
        mp.testRemove();
        mp.testEntrySet();
        mp.testModify();
        mp.testEntrySet();
    }
}
