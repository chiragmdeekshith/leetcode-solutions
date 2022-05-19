package medium;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagramsNonSortSlow(String[] strs) {
        if (strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        List<String> tempList;
        for (String str : strs) {
            boolean added = false;
            for (String s : map.keySet()) {
                if (isAnagram(str, s)) {
                    map.get(s).add(str);
                    added = true;
                    break;
                }
            }
            if (!added) {
                tempList = new ArrayList<>();
                tempList.add(str);
                map.put(str, tempList);
            }
        }
        return map.values().stream().toList();
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            smap.merge(s.charAt(i), 1, Integer::sum);
            tmap.merge(t.charAt(i), 1, Integer::sum);
        }
        if (smap.size() != tmap.size()) {
            return false;
        }
        for (Character c : smap.keySet()) {
            if (!(smap.get(c).equals(tmap.get(c)))) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagramsMedium(String[] strs) {
        if (strs.length < 1) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        String sorted;
        List<String> tempList;
        for (String str : strs) {
            sorted = sortString(str);
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }
            else{
                tempList = new ArrayList<>();
                tempList.add(str);
                map.put(sorted,tempList);
            }
        }
        return map.values().stream().toList();
    }

    private String sortString(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, List<String>> map = new HashMap<>();
        Integer key;
        List<String> tempList;
        for(String s: strs){
            key = getHashCodeForAnagramString(s);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return map.values().stream().toList();
    }
    private Integer getHashCodeForAnagramString(String s){
        // a - z is 26
        int[] integers = new int[26];
        for(Character c: s.toCharArray()){
            integers[c - 'a']++;
        }
        return Arrays.hashCode(integers);
    }
}
