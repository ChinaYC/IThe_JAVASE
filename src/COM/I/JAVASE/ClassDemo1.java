package COM.I.JAVASE;

public class ClassDemo1 {
    public static void main(String[] args) {
        //foo 的实例对象
        Foo foo1 = new Foo();
        //foo类本身也是class的实例对象
        //三种表示方式

        //第一种表示方式;--->任何一个类都有一个隐含的静态成员变量class
        Class c1 = Foo.class;

        //第二种表达方式;--->已经知道该类的对象通过getclass方法
        Class c2 = foo1.getClass();

        //官网c1，c2表示了类的类类型(class type)

        //不管c1 or c2都代表了Foo类
        System.out.println(c1==c2);

        //第三种表达方式;--->
        Class c3 = null;
        try {
            c3 = Class.forName("Foo");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        System.out.println(c2==c3);
    }
}
class Foo{}