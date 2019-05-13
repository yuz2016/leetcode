package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/4/7
 */
public class B_2_DeadLock {


    public static void main(String[] args) throws InterruptedException {
        Friend alphonse =
                new Friend("Alphonse");
        Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() { alphonse.bow(gaston); }
        }).start();
//        Thread.sleep(1000);
        new Thread(new Runnable() {
            public void run() { gaston.bow(alphonse); }
        }).start();
    }
}

class Friend {
    private final String name;
    public Friend(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public synchronized void bow(Friend bower) {
        System.out.format("%s: %s"
                        + "  has bowed to me!%n",
                this.name, bower.getName());
        bower.bowBack(this);
    }
    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s"
                        + " has bowed back to me!%n",
                this.name, bower.getName());
    }
}
