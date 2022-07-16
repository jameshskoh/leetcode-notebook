package Day02.LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }

        int minLength = shortestStringLength(strs);

        int i = 0;
        outerloop:
        while (i < minLength) {
            char firstChar = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (firstChar != strs[j].charAt(i))
                    break outerloop;
            }

            i++;
        }

        return strs[0].substring(0, i);
    }

    private int shortestStringLength(String[] strs) {
        int min = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min)
                min = strs[i].length();
        }

        return min;
    }
}
