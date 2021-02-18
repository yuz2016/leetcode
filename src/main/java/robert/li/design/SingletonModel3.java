package robert.li.design;

/**
 * 双重检测
 */
public class SingletonModel3 {
    private static SingletonModel3 singletonModel3;

    private SingletonModel3() {
    }

    public static SingletonModel3 getSingeton() {
        if(singletonModel3 == null) {
            synchronized (SingletonModel3.class) {
                if (singletonModel3 == null) {
                    singletonModel3 = new SingletonModel3();
                }
            }
        }
        return singletonModel3;
    }
}
