package ArraysHashing;

import java.util.*;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            putAnagram(groups, new String(chars), str);
        }

        List<List<String>> groupsList = new ArrayList<>(groups.size());
        groupsList.addAll(groups.values());

        return groupsList;
    }

    private void putAnagram(Map<String, List<String>> groups, String chars, String str) {
        if (groups.containsKey(chars)) {
            List<String> strings = groups.get(chars);
            strings.add(str);
        } else {
            List<String> strings = new ArrayList<>();
            strings.add(str);
            groups.put(chars, strings);
        }
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<List<Integer>, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            int[] freqs = new int[26];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                freqs[c - 'a']++;
            }

            List<Integer> key = new ArrayList<>(26);
            for (int f : freqs) key.add(f);

            putFreqAnagram(groups, key, str);
        }

        List<List<String>> groupsList = new ArrayList<>(groups.size());
        groupsList.addAll(groups.values());

        return groupsList;
    }

    private void putFreqAnagram(Map<List<Integer>, List<String>> groups, List<Integer> key, String string) {
        if (groups.containsKey(key)) {
            List<String> strings = groups.get(key);
            strings.add(string);
        } else {
            List<String> strings = new ArrayList<>();
            strings.add(string);
            groups.put(key, strings);
        }
    }

    public List<List<String>> groupAnagram3(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String str : strs) {
            char[] freqs = new char[26];

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                freqs[c - 'a']++;
            }

            String key = String.valueOf(freqs);

            putFreqAnagram2(groups, key, str);
        }

        List<List<String>> groupsList = new ArrayList<>(groups.size());
        groupsList.addAll(groups.values());

        return groupsList;
    }

    private void putFreqAnagram2(Map<String, List<String>> groups, String key, String string) {
        if (groups.containsKey(key)) {
            List<String> strings = groups.get(key);
            strings.add(string);
        } else {
            List<String> strings = new ArrayList<>();
            strings.add(string);
            groups.put(key, strings);
        }
    }

    public static void main(String[] args) {
        GroupAnagram s = new GroupAnagram();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        s.groupAnagrams(strs);
    }
}
