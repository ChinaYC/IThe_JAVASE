package COM.I.JAVASE

import java.util.HashMap
import kotlin.collections.Map.Entry
import java.util.Scanner

/**
 * 使用Map对学生类的增删改查
 */
class MapTest {

    /**
     * 用来承装学生类型对象
     * Map<key></key>,value>
     * @param args
     */
    var students: MutableMap<String, Student>

    /**
     * 添加构造方法
     * 在构造器中初始化students属性
     * @param args
     */
    init {
        this.students = HashMap()
    }

    /**
     * 测试添加:输入学生ID，判断是否被占用
     * 若魏碑占用,则输入姓名，创建新学生对象，
     * 并且添加到students中
     * @param args
     */
    fun testPut() {
        //创建一个Scanner对象,用来获取输入的学生ID和姓名
        val console = Scanner(System.`in`)
        var i = 0
        while (i < 3) {
            println("请输入学生ID:")
            val ID = console.next()
            //判断该ID是否已被占用
            val st = students[ID]
            if (st == null) {
                //提示输入学生姓名
                println("请输入学生姓名")
                val name = console.next()

                //创建新的学生对象
                val newStudent = Student(ID, name)

                //通过调用students的·put方法，添加ID-学生映射
                students[ID] = newStudent
                println("成功添加学生" + students[ID].name)
                i++
            } else {
                println("该学生ID已被占用！")
                continue
            }
        }
    }

    /**
     * 测试Map的keySet方法
     * @param args
     */
    fun testKeySet() {
        //通过KeySet方法，返回Map中的所有"键"的set集合
        val studentsKeySet = students.keys
        //取得stuents的容量
        println("总共有学生：" + students.size)

        //遍历KeySet,取得每一个键,再调用get方法取得每个键对应的value
        for (stuId in studentsKeySet) {
            val st = students[stuId]
            if (st != null) {
                println("学生:" + st.name)
            }
        }
    }

    /**
     * 通过entrySet方法来遍历Map
     * @param args
     */
    fun testEntrySet() {
        //通过entrySet方法,返回Map中的所有键值对
        val entrySet = students.entries
        for ((key, value) in entrySet) {
            println("取得键:$key")
            println("对应的值为:" + value.name)
        }
    }

    /**
     * 测试删除Map中的映射
     * @param args
     */
    fun testRemove() {
        val console = Scanner(System.`in`)

        while (true) {
            println("请输入要删除的学生ID")
            //获取从键盘输入的待删除的学生ID
            val ID = console.next()

            //判定该ID是否有对应的学生对象
            val st = students[ID]
            if (st == null) {
                //提示ID情况(此处为不存在)
                println("该ID不存在")
                continue
            }
            students.remove(ID)
            println("成功删除学生" + st.name)
            break

        }
    }

    /**
     * 利用put方法修改Map中的已有映射
     * @param args
     */
    fun testModify() {
        println("请输入要修改的学生ID")

        //创建一个Scanner对象，获取键盘上输入的学生ID字符串
        val console = Scanner(System.`in`)
        while (true) {
            //取得键盘上输入的学生ID
            val stuID = console.next()

            //从students中查找是否有相应的映射(该学生ID对应的学生对象)
            val student = students[stuID]
            if (stuID == null) {
                println("该ID不存在")
                continue
            }

            //提示当前对应的学生对象的姓名
            println("该ID下的学生" + student.name + "将修改改为?")
            //取得键盘上输入的学生name
            val stuName = console.next()
            val newStudent = Student(stuID, stuName)
            //添加入students的map中
            students[stuID] = newStudent

            println(student.name + "成功修改为:" + students[stuID].name)

            //别忘记跳出循环!!!
            break
        }
    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val mp = MapTest()
            mp.testPut()
            mp.testKeySet()
            mp.testRemove()
            mp.testEntrySet()
            mp.testModify()
            mp.testEntrySet()
        }
    }
}
