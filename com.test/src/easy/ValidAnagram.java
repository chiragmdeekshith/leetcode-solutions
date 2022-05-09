package easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        char schar, tchar;
        for (int i = 0; i < s.length(); i++) {
            smap.merge(s.charAt(i), 1, Integer::sum);
            tmap.merge(t.charAt(i), 1, Integer::sum);
        }
        if (smap.size() != tmap.size()) {
            return false;
        }
        return smap.equals(tmap);
    }
}
