package robert.li;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/3/18
 */
public class A_60_getPermutation {

    /**
     * 全排列后get
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if(n < 1) return "";
        int[] nums = getArr(n);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(lists, list, nums);
        List<Integer> res = lists.get(k-1);
        return listToString(res);
    }

    private String listToString(List<Integer> arr){
        String s = "";
        for(Integer i : arr){
            s=s+i;
        }
        return s;
    }

    private void helper(List<List<Integer>> lists, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int num : nums) {
            if (list.contains(num)) {
                continue;
            }
            list.add(num);
            helper(lists, list, nums);
            list.remove(list.size() - 1);
        }
    }

    public int[] getArr(int n) {
        int[] arr = new int[n];
        for( int i = 1;i <= n; i++){
            arr[i-1] = i;
        }
        return arr;
    }

    /**
     * 根据阶乘数组 求第k个的String
     * @param n
     * @param k
     * @return
     */
    public String getPermutation1(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }
}
