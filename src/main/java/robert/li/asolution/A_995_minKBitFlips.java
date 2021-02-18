package robert.li.asolution;

import java.util.Deque;
import java.util.LinkedList;

public class A_995_minKBitFlips {
    public static void main(String[] args) {

        A_995_minKBitFlips a_995_minKBitFlips = new A_995_minKBitFlips();
        a_995_minKBitFlips.minKBitFlips(new int[]{0,0,0,1,0,1,1,0}, 3);
    }
    public int minKBitFlips(int[] A, int K) {
        Deque<Integer> queue = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < A.length ; i++) {
            if(queue.size() > 0 && queue.peekFirst() < i - K + 1) {
                queue.pollFirst();
            }
            int isFlip = queue.size() % 2; // 0不反转 1 反转
            if((A[i] == 0 && isFlip == 0) || (A[i] == 1 && isFlip == 1)) {
                queue.addLast(i);
                res++;
                if(i + K > A.length) return -1;
            }
        }
        return res;
    }
}
