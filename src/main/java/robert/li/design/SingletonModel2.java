package robert.li.design;

/**
 * 懒汉式
 */
public class SingletonModel2 {

    private static SingletonModel2 singletonModel2;

    private SingletonModel2() {
    }

    public static synchronized SingletonModel2 getSingeton() {
        if(singletonModel2 == null) {
            singletonModel2 = new SingletonModel2();
        }
        return singletonModel2;
    }
}
