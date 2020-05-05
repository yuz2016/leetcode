package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/5/16
 */
public class B_7_RunTimeExceptionFinally {

    public static void main(String[] args) {
        try {
            System.out.println("try");
            throw new RuntimeException("funck");
        } finally {
            System.out.println("finally");
        }
    }
}
