package robert.li.volatiletest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/2/9
 */
public class volatileTest1 {
    private static volatile boolean flag = false;

    private static void refershFlag() throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {

            @Override
            public void run() {
                while (!flag) {
                    //do something
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {

            @Override
            public void run() {

                flag = true;
            }
        });

        DateFormat dateFormat  = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        System.out.println("threadA start" + dateFormat.format(new java.util.Date()));
        threadA.start();

        Thread.sleep(100);

        threadB.start();

        threadA.join();
        System.out.println("threadA end" + dateFormat.format(new java.util.Date()));
    }

    //threadA start2018/07/25 16:48:41

    public static void main(String[] args) throws InterruptedException {
        refershFlag();
    }

}
