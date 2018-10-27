package COM.I.JAVASE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
   public List<Course> coursesToSelect;

   private Scanner console;

   public  Student student;

   public SetTest(){
       //初始化coursesToSelect属性
       coursesToSelect = new ArrayList<Course>();
       console = new Scanner(System.in);
   }

    /**
     * 用于往courseToSelect中添加课程
     *
     */
    public void testAdd() {
        //创建一个课程对象，并通过调用add方法添加到备选课程List中
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);
        Course temp = (Course) coursesToSelect.get(0);
//        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        Course cr2 = new Course("2","C语言");
        coursesToSelect.add(0,cr2);
        Course temp2 = (Course) coursesToSelect.get(0);
//        System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);

//        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

//        coursesToSelect.add(cr1);
//        Course temp0 = (Course) coursesToSelect.get(2);
//        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

//        Course cr3 = new Course("3","test");
//        coursesToSelect.add(3,cr3);
//        添加两门课程
//        数组添加用 addAll(Arrays.asList());
        Course[] course = {new Course("3","离散数学"),new Course("4","汇编语言")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(1);
//        System.out.println(temp3.id+temp3.name+temp4.id+temp4.name);

        Course[] course2 = {new Course("5","离散数学"),new Course("6","大英")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(2);
        Course temp6 = (Course) coursesToSelect.get(3);
//        System.out.println(temp5.id+temp5.name+temp6.id+temp6.name);

    }

    /**
     * 通过for each方法访问集合元素
     * @param args
     */
    public void testForEach(){
        System.out.println("有如下课程待选(通过for each)");
//        for (Course cr:coursesToSelect){
//            System.out.println("课程"+cr.id+cr.name);
//        }
            for (Object obj:coursesToSelect){
                Course cr = (Course) obj;
                System.out.println("课程"+cr.id+cr.name);
            }
    }

    /**
     * 测试List的contains方法
     * @param args
     */
    public void testListContains(){
        //取得备选课程序列的第0个元素
        Course course = coursesToSelect.get(0);

        //打印输出courseToSelected是否包含course对象
        System.out.println("取得对象:"+course.name+
                "备选课程中是否包含:"+course.name+
                ","+coursesToSelect.contains(course));

        //提示输入课程名称
        System.out.println("请输入课程名称");
        String name = console.next();

        //创建一个新的课程对象,ID和名称,与course对象完全一样
        Course course2 = new Course();
        course2.name = name;

        System.out.println("新创建课程:"+course2.name);
        //(没重写equals前)虽然拥有相通的名称和ID但是不在列表里面，所以不包含，返回false
        System.out.println("备选课程是否包含"+course2.name+"，"+coursesToSelect.contains(course2));

        //通过indexOf位置来取得某元素的索引位置
        if(coursesToSelect.contains((course2))){
            System.out.println("课程:"+course2.name+"索引位置位:"+coursesToSelect.indexOf(course2));
        }

    }

    //创建学生对象并选课
    public void crateStudentAndSelectCours(){

        //创建一个学生对象
        Student student = new Student("1","小明");
        System.out.println("欢迎学生"+student.name+"选课");

        //创建一个Scanner对象，用来接收从键盘输入的课程ID
        Scanner console = new Scanner(System.in);

        /**
         * 获取3个键盘输入的值
         * 如果和课程ID相同的就记录到set<Course> courses中(学生所选课程)
         */
        for (int i=0;i<3;i++){
            System.out.println("请输入课程ID");
            String courseId = console.next();
            for (Course cr:coursesToSelect){
                if(cr.id.equals(courseId)){
                    student.courses.add(cr);
                    //set重复数据↓(无论添加多少次都只会保留一个该对象)
                    //而且保留的是第一次添加的那个
                    //有毒→  student.courses.add(null);
                }
            }
        }
    }

    /**
     * 测试Set的contain方法
     * @param args
     */
    public void testSetContains(){
        //提示输入课程名称
        System.out.println("请输入学生已选的课程名称1:");
        String name = console.next();

        //创建一个新的课程对象,ID和名称,与course对象完全一样
        Course course2 = new Course();
        course2.name = name;
        System.out.println("新创建课程:"+course2.name);
        //(没重写equals前)虽然拥有相通的名称和ID但是不在列表里面，所以不包含，返回false
        System.out.println("备选课程是否包含"+course2.name+"，"+student.courses.contains(course2));

    }

    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testForEach();
//
        st.crateStudentAndSelectCours();
        st.testSetContains();
//
//        st.testForEachForSet(student);
        st.testListContains();
    }
        public void testForEachForSet(Student st){
            //打印输出学生所选课程!
            System.out.println("选择的课程数量："+st.courses.size());
            for (Course cr:st.courses){
                System.out.println("学生选择课程:"+cr.id+cr.name);
            }
        }
}
