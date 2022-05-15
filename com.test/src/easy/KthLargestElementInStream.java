package easy;

import java.util.PriorityQueue;

public class KthLargestElementInStream {
    private int k;
    private PriorityQueue<Integer> minheap;

    public KthLargestElementInStream(int k, int[] nums) {
        this.k = k;
        minheap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minheap.add(val);
        if (minheap.size() > k) {
            minheap.poll();
        }
        return minheap.peek();
    }
}
