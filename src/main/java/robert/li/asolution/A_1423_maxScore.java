package robert.li.asolution;

public class A_1423_maxScore {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int sum = 0;
        for(int i = len - k; i < len; i++) {
            sum += cardPoints[i];
        }
        int left = len - k;
        int right = 0;
        int res = sum;
        while(right < k) {
            sum += cardPoints[right];
            sum -= cardPoints[left];
            res = Math.max(res, sum);
            left++;
            right++;
        }
        return res;
    }
}
