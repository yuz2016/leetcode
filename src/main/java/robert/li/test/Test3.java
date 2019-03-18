package robert.li.test;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/13
 */
public class Test3 {
    public static void main(String[] args) {
        boolean matches = "/api/earning/day/actual/all/all/query?businessScope=inter&limit=10&pageIndex=1&type=all&businessSource=all&startStatisticsTime=2018-12-04&endStatisticsTime=2018-12-13&_=1544753334641"
                .matches("/api/earning/day/actual/.*?businessScope=dom.*");
        System.out.println(matches);
        System.out.println(new Date());
        BigDecimal bigDecimal = new BigDecimal(12.10);
        ;
        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }
}
