package medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement_ForAllChars(String s, int k) {
        int result = 0;
        int maxFrequency = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            map.merge(s.charAt(j), 1, Integer::sum);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(j)));
            if (j - i + 1 - maxFrequency > k) {
                map.merge(s.charAt(i), -1, Integer::sum);
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result;
    }

    public int characterReplacement(String s, int k) {
        int result = 0;
        int maxFrequency = 0;
        char[] charArray = s.toCharArray();
        int[] freqArray = new int[26];
        int i = 0, j = 0;
        while (j < s.length()) {
            maxFrequency = Math.max(maxFrequency, ++freqArray[charArray[j] - 'A']);
            while (j - i + 1 - maxFrequency > k) {
                freqArray[charArray[i++] - 'A']--;
            }
            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
