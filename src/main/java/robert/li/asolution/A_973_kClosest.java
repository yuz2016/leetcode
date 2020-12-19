package robert.li.asolution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class A_973_kClosest {
    public static void main(String[] args) {

        A_973_kClosest a_973_kClosest = new A_973_kClosest();
        a_973_kClosest.kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(k, (i, j) -> sumOfSquares(j[0], j[1]) - sumOfSquares(i[0], i[1]));
        for (int i = 0; i < points.length; i++) {
            if(i < k) {
                maxHeap.add(points[i]);
            } else {
                if(sumOfSquares(points[i][0], points[i][1]) < sumOfSquares(maxHeap.peek()[0], maxHeap.peek()[1])) {
                    maxHeap.poll();
                    maxHeap.add(points[i]);
                }
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        for (int[] ints : maxHeap) {
            res[i] = ints;
            i++;
        }
        return res;
    }

    int sumOfSquares(int x, int y) {
        return x * x + y * y;
    }
}
