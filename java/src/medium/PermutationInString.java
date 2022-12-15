package medium;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() == 1) {
            return s2.contains(s1);
        }
        if (s2.isEmpty() || s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.merge(s1.charAt(i), 1, Integer::sum);
            s2Map.merge(s2.charAt(i), 1, Integer::sum);
        }
        if (s1Map.equals(s2Map)) {
            return true;
        }
        for (int i = 0, j = s1.length() - 1; j < s2.length(); i++, j++) {
            char ch = s2.charAt(i);
            s2Map.merge(ch, -1, Integer::sum);
            if (s2Map.get(ch) < 1) {
                s2Map.remove(ch);
            }
            s2Map.merge(s2.charAt(j), 1, Integer::sum);
            if (s1Map.equals(s2Map)) {
                return true;
            }
        }
        return false;
    }
}
