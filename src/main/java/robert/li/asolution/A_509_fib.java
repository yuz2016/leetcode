package robert.li.asolution;

public class A_509_fib {
    public int fib(int n) {
        if(n == 0) return 0;
        int a = 0, b = 1;
        for(int i = 2; i <= n; i++) {
            int tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;
    }
}
