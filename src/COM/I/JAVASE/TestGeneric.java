package COM.I.JAVASE;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {

    /**
     * 带有泛型-Course
     */
    public List<Course> courses;

    public TestGeneric(){
        this.courses = new ArrayList<Course>();
    }

    /**
     * 测试添加
     * @param args
     */
    public void testAdd(){
        Course cr1 = new Course("1","大中");
        courses.add(cr1);
       //泛型集合中，不能添加泛型规定的类型以外的对象，否则会报错
        Course cr2 = new Course("2","java基础");
        courses.add(cr2);
    }

    /**
     * 测试循环遍历
     * @param args
     */
    public void testForEach(){
        for(Course cr:courses){
            System.out.println(cr.id+":"+cr.name);
        }
    }

    public static void main(String[] args) {
        TestGeneric tg = new TestGeneric();
        tg.testAdd();
        tg.testForEach();
    }
}
