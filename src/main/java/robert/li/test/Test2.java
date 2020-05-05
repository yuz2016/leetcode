package robert.li.test;

import com.google.common.base.Splitter;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/12
 */
public class Test2 {
    public static void main(String[] args) {
        String s = "USD-999.8-792966-LI/YING-1.3170554452215E13-ENETT2018030904013066646017313-2.100476247E9";
        System.out.println(s.indexOf("-",s.indexOf("-")+1));
        System.out.println(s.indexOf("-", s.indexOf("-", s.indexOf("-") + 1)+1));
        //        s.substring();
        System.out.println(Splitter.on("-").trimResults().splitToList(s).get(2).substring(0,6));
    }
}
