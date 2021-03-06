package COM.I.JAVASE;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 将要完成:
 * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
 * 2,对String泛型的List进行排序；
 * 3,对其它类型泛型的List进行排序，以Student为例；
 * @param args
 */
public class CollectionsTest {
    /**
     * 1.通过Collections.sort()方法，对Integer泛型的List进行排序；
     * 创建一个Integer泛型的List，并且添加十个100以内的不重复的随机整数，
     * 调用Collections.sort()方法对其排序
     * @param args
     */
    public void testSort1(){
        //只能使用基本类型的包装类作为泛型
        List<Integer> integerList = new ArrayList<Integer>();
        //插入十个100以内的随机整数
        Random random = new Random();
        int k;
        for (int i = 0;i<10;i++){
            do {
                k = random.nextInt(100);
            }while (integerList.contains(k));
            integerList.add(k);
            System.out.println("成功添加整数"+k);
        }
        System.out.println("---------排序前-----------");
        for (int integer:integerList){
            System.out.println("元素"+integer);
        }
        //就这一段代码，为排序关键！
        Collections.sort(integerList);
        System.out.println("---------排序排后-----------");
        for (int in:integerList){
            System.out.println("元素"+in);
        }

    }

    /**
     * 2.对String泛型的List进行排序；
     * 创建一个泛型为String的list，添加三个乱序的String元素，
     * 调用sort方法，再次输出排序后的顺序
     * @param args
     */
    public void testSort2(){
        List<String> stingList = new ArrayList<String>();
        stingList.add("microsoft");
        stingList.add("google");
        stingList.add("lenovo");
        System.out.println("----------排序前-----------");
        for (String string:stingList){
            System.out.println("元素"+string);
        }
        Collections.sort(stingList);
        System.out.println("----------排序后-----------");
        for (String st:stingList )
            System.out.println("元素"+st);
    }


    /**
     * 3.对其他类型泛型的List进行排序，以Student为例
     */
    public void testSort3(){
        List<Student> studentList = new ArrayList<Student>();
        Random random = new Random();
        //测试用，不判断随机id是否重复，故写1000内随机，大一点避免重复
        studentList.add(new Student(random.nextInt(1000)+"","Mike"));
        studentList.add(new Student(random.nextInt(1000)+"","Angela"));
        studentList.add(new Student(random.nextInt(1000)+"","Lucy"));
        studentList.add(new Student(10000+"","Beyonce"));
        System.out.println("---------------排序前------------------");
        for (Student st:studentList){
            System.out.println(" 学生:"+st.id+":"+st.name);
        }
        Collections.sort(studentList);
        System.out.println("---------------排序后------------------");
        for(Student student:studentList){
            System.out.println("学生"+student.id+":"+student.name);
        }
        Collections.sort(studentList,new StudentComparator());
        System.out.println("---------------按照姓名排序后-----------------");
        for (Student st:studentList){
            System.out.println("学生"+st.id+":"+st.name);
        }
    }

    public static void main(String[] args) {
        CollectionsTest ct = new CollectionsTest();
//        ct.testSort1();
//        ct.testSort2();
        ct.testSort3();
    }
}
