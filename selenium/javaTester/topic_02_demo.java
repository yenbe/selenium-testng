package javaTester;

import org.openqa.selenium.firefox.FirefoxDriver;

public class topic_02_demo {
    int x;

    public static void main(String[] args) {
       float  x = 4.5f;
       float y=x;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        x = 25;
        System.out.println("x = " + x);
        System.out.println("y = " + y);

        topic_02_demo a = new topic_02_demo();
        a.x = 5;
        System.out.println("a.x = " + a.x);

        topic_02_demo d = a;
        System.out.println("d.x = " + d.x);
        a.x = 200;
        System.out.println("a.x = " + a.x);
        System.out.println("d.x = " + d.x);
    }

}
