package robert.li.design;

public class SingletonModel4 {

    private SingletonModel4() {
    }

    public static SingletonModel4 getSingeton() {
        return SingletonModel4Holder.singletonModel4;
    }

    private static class SingletonModel4Holder {
        private static final SingletonModel4 singletonModel4 = new SingletonModel4();
    }
}
