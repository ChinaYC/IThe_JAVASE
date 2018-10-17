package COM.I.JAVASE;

import java.util.Arrays;

public class HELLO {
    public static void main(String[] args) {
        //定义数组
        int[] scores= {89,-23,64,91,119,52,73};
        System.out.println("前三名");
        HELLO hello = new HELLO();
        hello.showTop(scores);
    }

    /*
     * 功能：创建指定长度的int型数组，并生成100以内随机数为数组中的每个元素赋值
     * 定义一个带参带返回值的方法，通过参数传入数组的长度，返回赋值后的数组
     */
    public void showTop(int[] scores){
        Arrays.sort(scores);
        int num = 0;
        //注意数组下标越界
        for (int i=scores.length-1;i>=0;i--){
            //判断成绩
            if ((scores[i] < 0) || (100 < scores[i])){
                continue;
            }
            num++;
            //达到条件输出
            if( num>3 ){
                break;
            }
            System.out.println(scores[i]);
        }
    }
}
