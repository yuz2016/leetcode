package robert.li.asolution;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-02
 */
public class A_378_kthSmallest {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2}, {1, 3}};
        A_378_kthSmallest a_378_kthSmallest = new A_378_kthSmallest();
        int i = a_378_kthSmallest.kthSmallest(arr, 3);
        System.out.println(i);
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] row : matrix) {
            for (int i : row) {
                if (maxPQ.size() < k) {
                    maxPQ.add(i);
                } else if (maxPQ.size() == k && i < maxPQ.peek()) {
                    maxPQ.remove();
                    maxPQ.add(i);
                }
            }
        }
        return maxPQ.peek();
    }

    public int kthSmallest1(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix[0].length - 1];
        while(left < right) {
            int mid = left + (right - left) / 2;
            int count = countNotMoreThanMid(matrix, mid);
            if(count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int countNotMoreThanMid(int[][] matrix, int mid) {
        int i = matrix.length - 1;
        int j = 0;
        int count = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(matrix[i][j] <= mid) {
                count += i + 1;
                j--;
            } else {
                i++;
            }
        }
        return count;
    }
}
