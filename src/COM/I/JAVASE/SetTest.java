package COM.I.JAVASE

import java.util.ArrayList
import java.util.Arrays
import java.util.Scanner

class SetTest {
    var coursesToSelect: MutableList<Course>

    init {
        //初始化coursesToSelect属性
        coursesToSelect = ArrayList()
    }

    /**
     * 用于往courseToSelect中添加课程
     *
     */
    fun testAdd() {
        //创建一个课程对象，并通过调用add方法添加到备选课程List中
        val cr1 = Course("1", "数据结构")
        coursesToSelect.add(cr1)
        val temp = coursesToSelect[0]
        //        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        val cr2 = Course("2", "C语言")
        coursesToSelect.add(0, cr2)
        val temp2 = coursesToSelect[0]
        //        System.out.println("添加了课程：" + temp2.id + ":" + temp2.name);

        //        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        //        coursesToSelect.add(cr1);
        //        Course temp0 = (Course) coursesToSelect.get(2);
        //        System.out.println("添加了课程：" + temp.id + ":" + temp.name);

        //        Course cr3 = new Course("3","test");
        //        coursesToSelect.add(3,cr3);
        //        添加两门课程
        //        数组添加用 addAll(Arrays.asList());
        val course = arrayOf(Course("3", "离散数学"), Course("4", "汇编语言"))
        coursesToSelect.addAll(Arrays.asList(*course))
        val temp3 = coursesToSelect[2]
        val temp4 = coursesToSelect[1]
        //        System.out.println(temp3.id+temp3.name+temp4.id+temp4.name);

        val course2 = arrayOf(Course("5", "离散数学"), Course("6", "大英"))
        coursesToSelect.addAll(2, Arrays.asList(*course2))
        val temp5 = coursesToSelect[2]
        val temp6 = coursesToSelect[3]
        //        System.out.println(temp5.id+temp5.name+temp6.id+temp6.name);

    }

    /**
     * 通过for each方法访问集合元素
     * @param args
     */
    fun testForEach() {
        println("有如下课程待选(通过for each)")
        //        for (Course cr:coursesToSelect){
        //            System.out.println("课程"+cr.id+cr.name);
        //        }
        for (obj in coursesToSelect) {
            println("课程" + obj.id + obj.name)
        }
    }

    fun testForEachForSet(st: Student) {
        //打印输出学生所选课程!
        println("选择的课程数量：" + st.courses.size)
        for (cr in st.courses) {
            println("学生选择课程:" + cr.id + cr.name)
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val st = SetTest()
            st.testAdd()
            st.testForEach()

            //创建一个学生对象
            val student = Student("1", "小明")
            println("欢迎学生" + student.name + "选课")

            //创建一个Scanner对象，用来接收从键盘输入的课程ID
            val console = Scanner(System.`in`)

            /**
             * 获取3个键盘输入的值
             * 如果和课程ID相同的就记录到set<Course> courses中(学生所选课程)
            </Course> */
            for (i in 0..2) {
                println("请输入课程ID")
                val courseId = console.next()
                for (cr in st.coursesToSelect) {
                    if (cr.id == courseId) {
                        student.courses.add(cr)
                        //set重复数据↓(无论添加多少次都只会保留一个该对象)
                        //而且保留的是第一次添加的那个
                        //有毒→  student.courses.add(null);
                    }
                }
            }

            st.testForEachForSet(student)
        }
    }
}
