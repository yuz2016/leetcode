package robert.li.design;

/**
 * 饿汉式
 */
public class SingletonModel1 {

    private static final SingletonModel1 singletonModel1 = new SingletonModel1();

    private SingletonModel1() {
    }

    public static SingletonModel1 getSingeton() {
        return singletonModel1;
    }
}
