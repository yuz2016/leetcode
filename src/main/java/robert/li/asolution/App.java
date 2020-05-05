package robert.li.asolution;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 * Hello world!
 */
public class App {

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(1);
    private static Semaphore C = new Semaphore(1);

    public static void main(String[] args) throws InterruptedException {
        Scanner cin = new Scanner(System.in);
        String next = cin.next();
        System.out.print(next);
        B.acquire();
        C.acquire(); // 开始只有A可以获取, BC都不可以获取, 保证了A最先执行
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }

    static class ThreadA extends Thread {

        @Override public void run() {
            try {

                A.acquire();
                System.out.print("_A");
                B.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadB extends Thread {

        @Override public void run() {
            try {

                B.acquire();
                System.out.print("_B");
                C.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class ThreadC extends Thread {

        @Override public void run() {
            try {

                C.acquire();
                System.out.println("_C");
                A.release();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    //    public static void main( String[] args )
    //    {
    //        System.out.println( "Hello World!" );
    //    }
}
