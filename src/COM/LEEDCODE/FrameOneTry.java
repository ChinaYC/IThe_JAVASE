package COM.LEEDCODE;

import java.awt.Frame;

public class FrameOneTry {
    public static void main(String[] args) {
        Frame frame = new Frame();
        //设置窗口名
        frame.setTitle("人生第一个窗口");

        //设置窗口大小
        frame.setSize(500,400);
        //设置窗口距离左边和上边距离
        frame.setLocation(300,400);
        frame.setVisible(true);
    }
}
