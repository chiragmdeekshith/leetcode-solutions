package medium;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int start=0, end = 0; end < s.length(); end++){
            if (map.containsKey(s.charAt(end))){
                start = Math.max(start, map.get(s.charAt(end)));
            }
            max = Math.max(max, end-start + 1);
            map.put(s.charAt(end), end + 1);
        }

        return max;
    }
}
