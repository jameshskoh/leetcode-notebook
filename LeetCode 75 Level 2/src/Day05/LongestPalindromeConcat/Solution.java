package Day05.LongestPalindromeConcat;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> hitCounter = new HashMap<>();
        HashSet<String> checked = new HashSet<>();
        int totalCount = 0;
        boolean identical = false;

        for (int i = 0; i < words.length; i++) {
            if (hitCounter.containsKey(words[i])) {
                int val = hitCounter.get(words[i]);
                hitCounter.put(words[i], val + 1);
            } else {
                hitCounter.put(words[i], 1);
            }
        }

        for (String word : hitCounter.keySet()) {
            if (checked.contains(word)) continue;

            checked.add(word);
            char char1 = word.charAt(0);
            char char2 = word.charAt(1);

            if (char1 == char2) {
                int wordCount = hitCounter.get(word);
                totalCount += wordCount / 2;

                if (wordCount %2 == 1) identical = true;
            } else {
                StringBuilder sb = new StringBuilder(word);
                String inverse = sb.reverse().toString();

                if (hitCounter.containsKey(inverse)) {
                    checked.add(inverse);

                    int wordCount = hitCounter.get(word);
                    int invCount = hitCounter.get(inverse);

                    totalCount += Math.min(wordCount, invCount);
                }
            }
        }

        return totalCount * 4 + (identical ? 2 : 0);
    }
}