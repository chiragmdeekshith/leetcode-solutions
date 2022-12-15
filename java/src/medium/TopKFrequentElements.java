package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxheap = new PriorityQueue<>((Map.Entry a, Map.Entry b) -> ((Integer) b.getValue() - (Integer) a.getValue()));
        for (Map.Entry entry : map.entrySet()) {
            maxheap.add(entry);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = maxheap.poll().getKey();
        }
        return result;
    }
}
