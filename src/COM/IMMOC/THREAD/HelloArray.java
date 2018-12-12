package COM.IMMOC.THREAD;

public class HelloArray {
    private void helloArray(){
        char[] helloArray = {'H','E','L','L','O'};
        String helloString = new String(helloArray);
        //直接输出
        System.out.println(helloString);
    }

    private void StringToChar(){
        String helloString = "hello，the java8 let me to though more。。";//直接声明一个字符串变量赋值
        char[] helloArray = helloString.toCharArray();

        //假装是个寄存器
        byte countLetter = 0 ,countNumber = 0 , countString = 0;

        /**
         * 统计字符串中字母。数字图以及其它字符的个数。
          */
        for (byte i=0;i<helloArray.length;i++){
            //判断
            if(helloArray[i]<='z'&&helloArray[i]>='a'||(helloArray[i]>='A'&&helloArray[i]<='Z')){
                countLetter +=1;
            }


            }

        System.out.println(countLetter);
    }

    public static void main(String[] args) {
        HelloArray HA = new HelloArray();
        HA.helloArray();
        HA.StringToChar();
    }


}
