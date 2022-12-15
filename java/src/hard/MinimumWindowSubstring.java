package hard;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindowSlow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.merge(t.charAt(i), 1, Integer::sum);
            smap.merge(s.charAt(i), 1, Integer::sum);
        }
        String result = "";
        Integer minLength = Integer.MAX_VALUE;
        for (int i = 0, j = t.length(); i < j; ) {
            if (isSubstring(smap, tmap)) {
                if (minLength > j - i + 1) {
                    minLength = j - i + 1;
                    result = s.substring(i, j);
                }
                smap.merge(s.charAt(i), -1, Integer::sum);
                i++;
            } else if (j < s.length()) {
                smap.merge(s.charAt(j), 1, Integer::sum);
                j++;
            } else {
                break;
            }
        }
        return result;
    }

    private static boolean isSubstring(Map<Character, Integer> smap, Map<Character, Integer> tmap) {
        for (Character ch : tmap.keySet()) {
            if (!smap.containsKey(ch) || tmap.get(ch) > smap.get(ch)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        if (s.equals(t)) {
            return t;
        }
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tmap.merge(t.charAt(i), 1, Integer::sum);
        }
        Integer minLength = Integer.MAX_VALUE;
        String result = "";
        int have = 0;
        int need = tmap.size();
        Map<Character, Integer> smap = new HashMap<>();

        for (int i = 0, j = 0; j < s.length(); j++) {
            Character charAtJ = s.charAt(j);
            smap.merge(charAtJ, 1, Integer::sum);
            if (tmap.containsKey(charAtJ) && (smap.get(charAtJ).equals(tmap.get(charAtJ)))) {
                have++;
            }
            while (have == need) {
                if (minLength > j - i + 1) {
                    minLength = j - i + 1;
                    result = s.substring(i, j+1);
                }
                Character charAtI = s.charAt(i);
                smap.merge(charAtI, -1, Integer::sum);
                if (tmap.containsKey(charAtI) && smap.get(charAtI) < tmap.get(charAtI)) {
                    have--;
                }
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s,t;
        try {
            s = Files.readString(Path.of("com.test/data/LongString1.txt"));
            t = Files.readString(Path.of("com.test/data/LongString2.txt"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new MinimumWindowSubstring().minWindow(s, t);
    }
}
