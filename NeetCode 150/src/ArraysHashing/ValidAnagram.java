package ArraysHashing;

public class ValidAnagram {
    // this would only support lowercase characters
    // support for unicode should use HashMap instead

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int len = s.length();

        int[] sCharCount = new int[26];
        int[] tCharCount = new int[26];

        for (int i = 0; i < len; i++) {
            int sIdx = s.charAt(i) - 'a';
            sCharCount[sIdx]++;

            int tIdx = t.charAt(i) - 'a';
            tCharCount[tIdx]++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCharCount[i] != tCharCount[i]) return false;
        }

        return true;
    }
}
