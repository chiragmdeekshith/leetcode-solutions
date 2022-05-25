package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingChars {
    public int lengthOfLongestSubstringSlow(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() < 2) {
            return s.length();
        }
        int result = 0;
        int i = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                while (i < j && s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                result = Math.max(result, set.size());
                j++;
            }
        }

        return result;
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)));
            }
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }

        return max;
    }
}
