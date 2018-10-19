package COM.I.JAVASE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 备选课程类
 *增删改查（add remove set get）
 */

public class ListTest {
    /**
     * 用于存放备选课程的List
      */
    public List coursesToSelect;
    public ListTest(){
        this.coursesToSelect = new ArrayList();
    }

    /**
     * 用于往courseToSelect中添加课程
      */
    public void testAdd() {
        //创建一个课程对象，并通过调用add方法添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        Course cr2 = new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);

        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        coursesToSelect.add(cr1);
        Course temp0 = (Course) coursesToSelect.get(2);
        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

//        Course cr3 = new Course("3","test");
//        coursesToSelect.add(3,cr3);
//        添加两门课程
//        数组添加用 addAll(Arrays.asList());
          Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
          coursesToSelect.addAll(Arrays.asList(course));
          Course temp3 = (Course) coursesToSelect.get(3);
          Course temp4 = (Course) coursesToSelect.get(4);
        System.out.println(temp3.id+temp3.name+temp4.id+temp4.name);

        Course[] course2 = {new Course("5","离散数学"),new Course("6","大英")};
                coursesToSelect.addAll(2,Arrays.asList(course2));
                Course temp5 = (Course) coursesToSelect.get(2);
                Course temp6 = (Course) coursesToSelect.get(3);
        System.out.println(temp5.id+temp5.name+temp6.id+temp6.name);

    }
    /**
     * 得到的List中的元素方法
     */
    public void testGet(){
        //查询courseToSelect的长度
        int size = coursesToSelect.size();
        System.out.println("有如下课程待选");
        for (int i = 0; i<size; i++){
            Course cr = (Course) coursesToSelect.get(i);
            System.out.println("课程"+cr.id+":"+cr.name);

        }
    }

    /**
     * 通过迭代器来遍历List
     * 导入iterator
     * @param args
     */
    public void tesyIterator(){
       // 通过集合的iterator获得实例
        Iterator it = coursesToSelect.iterator();
        System.out.println("迭代器获得：");
        while(it.hasNext()){
            Course cr = (Course) it.next();
            System.out.println("课程"+cr.id+":"+cr.name);
        }
    }

    /**
     * 通过for aech方法访问集合元素
     * （其实就是迭代器的简便写法）
     * @param args
     */
    public  void testForEach(){
        System.out.println("for each获得");
        for(Object obj:coursesToSelect){
            Course cr = (Course) obj;

//            System.out.println("课程"+obj);
            System.out.println("课程"+cr.id+":"+cr.name);
        }
    }

    /**
     * 修改List中的元素
     * @param args
     */
    public void testModify(){
        coursesToSelect.set(4,new Course("7","毛概"));
    }

    /**
     * 删除List中元素
     * @param args
     */
    public void testRemove(){
        Course cr = coursesToSelect.get(4);
        System.out.println("我是课程"+cr.id+":"+cr.name+",删除中。。。");

    }

    public static void main(String[] args) {
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.tesyIterator();
        lt.testForEach();
        lt.testModify();
        lt.testForEach();
    }
}
