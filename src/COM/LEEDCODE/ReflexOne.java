package COM.LEEDCODE;

import java.util.Date;

public class ReflexOne {
    public static void main(String[] args) {
//        /**
//         * 三种反射常见反射
//         */
//        Date d = new Date();
//        Class<?> c = d.getClass();
//        System.out.println(c);
//
//        Class<?> c2 = Date.class;
//        System.out.println(c2);
//
//        Class<?> c3 = Class.forName("java.util.Date");
//        System.out.println(c3);
        ReflexPerson RP = new ReflexPerson();
        System.out.println(RP);

//       Class<?> c = Class.forName(ReflexPerson);
    }
}
