package medium;


import java.util.*;

public class LongestConsecutiveSequence {
    public int longestConsecutiveSlow(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (Integer num : nums) {
            set.add(num);
        }
        int current;
        for (Integer num : nums) {
            if (!set.contains(num - 1)) {
                for (current = 0; set.contains(num + current); current++) ;
                max = Math.max(max, current);
            }
        }
        return max;
    }

    public int longestConsecutiveMedium(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int longest = 0;
        for (Integer num : nums) {
            map.put(num, false);
        }
        int current;
        int prev;
        int next;
        for (Integer num : nums) {
            if (!map.get(num)) {
                map.put(num, true);
                current = 1;
                prev = num - 1;
                next = num + 1;
                while (!Objects.isNull(map.get(prev))) {
                    map.put(prev, true);
                    prev--;
                    current++;
                }
                while (!Objects.isNull(map.get(next))) {
                    map.put(next, true);
                    next++;
                    current++;
                }
                longest = Math.max(longest, current);
            }
        }
        return longest;
    }

    //for fast, just use efficient sorting algorithm, and give the longest length
}
