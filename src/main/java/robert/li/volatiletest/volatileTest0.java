package robert.li.volatiletest;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/2/9
 */
public class volatileTest0 {

    private volatile static int increaseI = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 50000; i++) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {

                    increaseI++;
                }
            }, String.valueOf(i));
            thread.start();
        }

        while(Thread.activeCount()>1)
            Thread.yield();
        System.out.println(increaseI);
    }

}
