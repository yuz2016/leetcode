package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/1/13
 */
public class B_1_singleton {

    private static B_1_singleton singleton = null;
    private B_1_singleton() {
    }

    public B_1_singleton getSingleton(){
        if(singleton == null){
            synchronized (B_1_singleton.class){
                if(singleton == null){
                    singleton = new B_1_singleton();
                }
            }
        }
        return singleton;
    }
}
