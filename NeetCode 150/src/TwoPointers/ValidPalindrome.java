package TwoPointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();

        if (len == 1) return true;

        int pt1 = 0;
        int pt2 = len - 1;

        while (true) {
            while (!Character.isLetterOrDigit(s.charAt(pt1))) {
                pt1++;
                if (pt1 >= pt2) return true;
            }

            while (!Character.isLetterOrDigit(s.charAt(pt2))) {
                pt2--;
                if (pt1 >= pt2) return true;
            }

            if (Character.toLowerCase(s.charAt(pt1)) != Character.toLowerCase(s.charAt(pt2)))
                return false;

            pt1++;
            pt2--;
            if (pt1 >= pt2) return true;
        }
    }
}
