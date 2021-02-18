package robert.li.asolution;

import java.util.PriorityQueue;

public class A_703_KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public static void main(String[] args) {
        A_703_KthLargest a_703_kthLargest = new A_703_KthLargest(3, new int[]{4, 5, 8, 2});
        a_703_kthLargest.add(3);
        a_703_kthLargest.add(5);
        a_703_kthLargest.add(10);
        a_703_kthLargest.add(9);
        a_703_kthLargest.add(4);
    }
    public A_703_KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < nums.length; i++) {
            if(pq.size() < k) {
                pq.add(nums[i]);
            } else
            if(pq.size() == k && pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
        } else
        if(pq.size() == k && pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
