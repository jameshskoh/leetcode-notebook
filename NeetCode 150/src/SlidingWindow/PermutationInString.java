package SlidingWindow;

import java.util.Set;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] charFreqs = new int[26];
        int[] cumCharFreqs = new int[26];
        int subCount = 0;

        setCharFreqs(charFreqs, s1);

        int pt1 = 0;
        int pt2 = 0;
        boolean in = false;

        while (pt2 < s2.length()) {
            char c2 = s2.charAt(pt2);
            if (charFreqs[c2 - 'a'] <= cumCharFreqs[c2 - 'a']) {
                if (in) {
                    if (charFreqs[c2 - 'a'] == 0) {
                        while (pt1 != pt2) {
                            char c1 = s2.charAt(pt1);
                            cumCharFreqs[c1 - 'a']--;
                            subCount--;
                            pt1++;
                        }

                        in = false;
                    } else {
                        while (s2.charAt(pt1) != c2) {
                            char c1 = s2.charAt(pt1);
                            cumCharFreqs[c1 - 'a']--;
                            subCount--;
                            pt1++;
                        }

                        cumCharFreqs[c2 - 'a']--;
                        subCount--;
                        pt1++;
                    }
                } else {
                    pt2++;
                    pt1 = pt2;
                }
            } else {
                in = true;
                cumCharFreqs[c2 - 'a']++;
                subCount++;

                if (subCount == s1.length()) return true;

                pt2++;
            }
        }

        return false;
    }

    private void setCharFreqs(int[] charFreqs, String s1) {
        for (char c : s1.toCharArray()) {
            charFreqs[c - 'a']++;
        }
    }

    public static void main(String[] args) {
        PermutationInString s = new PermutationInString();
        s.checkInclusion("ab", "eidbaooo");
    }
}
