package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

public class A_228_summaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        if(nums.length == 1) {
            String tmp = Integer.toString(nums[0]);
            res.add(tmp);
            return res;
        }
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] + 1){
                end = i;
            } else {
                addStr(nums, res, start, end);
                start = end = i;
            }
            if(i == nums.length - 1) {
                addStr(nums, res, start, end);
            }
        }
        return res;
    }

    private void addStr(int[] nums, List<String> res, int start, int end) {
        if(start == end) {
            String tmp = Integer.toString(nums[start]);
            res.add(tmp);
        } else {
            String tmp = (nums[start]) + "->" + (nums[end]);
            res.add(tmp);
        }
    }
}
