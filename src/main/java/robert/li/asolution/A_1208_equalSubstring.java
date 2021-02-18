package robert.li.asolution;

public class A_1208_equalSubstring {
    public int equalSubstring(String s, String t, int maxCost) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int[] costs = new int[charsS.length];
        for (int i = 0; i < charsS.length; i++) {
            costs[i] = Math.abs(charsS[i] - charsT[i]);
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = 0;
        while(right < charsS.length) {
            sum += costs[right];
            while (sum > maxCost) {
                sum -= costs[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

}
