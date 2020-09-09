package robert.li.asolution;

import java.util.LinkedList;
import java.util.List;

public class A_93_restoreIpAddresses {
    public static void main(String[] args) {
        A_93_restoreIpAddresses a_93_restoreIpAddresses = new A_93_restoreIpAddresses();
        a_93_restoreIpAddresses.restoreIpAddresses("1111");
    }

    List<String> list = null;
    List<String> res = null;

    public List<String> restoreIpAddresses(String s) {
        list = new LinkedList<>();
        res = new LinkedList<>();
        helper(s, 0);
        return res;
    }

    void helper(String s, int start) {

        // 目标
        if(list.size() == 4 && start == s.length()) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                if( i > 0 ) {
                    tmp.append(".").append(list.get(i));
                } else {
                    tmp.append(list.get(i));
                }
            }
            res.add(tmp.toString());
            return;
        }
        if(start == s.length()) {
            return;
        }
        if(list.size() == 4 && start < s.length()) {
            return;
        }
        // 选择
        for(int i = 1; i < 4; i++) {
            // 剪枝 约束
            if(s.charAt(start) == '0' && i > 1) {
                continue;
            }
            if(start + i > s.length()) continue;
            String substring = s.substring(start, start + i);
            int parseInt = Integer.parseInt(substring);
            if(parseInt > 255) {
                continue;
            }
            list.add(substring);
            helper(s, start + i);
            list.remove(list.size() - 1);
        }
    }
}
