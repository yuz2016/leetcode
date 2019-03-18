package robert.li;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/28
 */
public class A_929_NumUniqueEmails {

    public static void main(String[] args) {
        String[] strings = new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        A_929_NumUniqueEmails numUniqueEmails = new A_929_NumUniqueEmails();
        int i = numUniqueEmails.numUniqueEmails(strings);
        int a = 0;
    }


    /**
     *
     * @param emails
     * @return
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> collect = Arrays.stream(emails).map(this::transform).collect(Collectors.toSet());
        return collect.size();
    }

    private String transform(String email){
        String str = email.substring(0,email.indexOf('@'));
        if(str.indexOf('+') != -1){
            str = str.substring(0,str.indexOf('+'));
        }

//        str.replace();

        char[] chars = str.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            if(aChar != '.'){
                characters.add(aChar);
            }
        }
        char[] chars1 = new char[characters.size()];
        for (int i = 0; i < characters.size(); i++) {
            chars1[i] = characters.get(i);
        }

        return String.valueOf(chars1)+email.substring(email.indexOf('@'),email.length());
    }
}
