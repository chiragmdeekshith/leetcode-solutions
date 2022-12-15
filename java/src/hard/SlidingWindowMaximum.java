package hard;

import java.util.*;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindowSlow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());//(a,b)-> b-a

        for (int i = 0, j = 0; j <= nums.length; i++, j++) {
            while (maxHeap.size() < k) {
                maxHeap.add(nums[j++]);
            }
            list.add(maxHeap.peek());
            if (j == nums.length) {
                break;
            }
            maxHeap.remove(nums[i]);
            maxHeap.add(nums[j]);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0, j = 0; j < nums.length; j++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[j]) {
                deque.removeLast();
            }
            deque.addLast(j);
            if (i > deque.getFirst()) {
                deque.removeFirst();
            }
            if (j - i >= k - 1) {
                result[i++] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3);
    }
}
