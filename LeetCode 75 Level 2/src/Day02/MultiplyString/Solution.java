package Day02.MultiplyString;

public class Solution {
    public String multiply(String num1, String num2) {
        // edge cases, 0 or 1
        if (num1.equals("0")) {
            return "0";
        } else if (num1.equals("1")) {
            return num2;
        } else if (num2.equals("0")) {
            return "0";
        } else if (num2.equals("1")) {
            return num1;
        }

        int[] num1Arr = stringToArray(num1);
        int[] num2Arr = stringToArray(num2);

        int[] result = new int[num1Arr.length + num2Arr.length];

        int carry = 0;
        // the last k: k = result.length - 1 can only be found from carry
        // looping through it would give index out of bound exception
        for (int k = 0; k < result.length - 1; k++) {
            int sum = carry;

            for (int i = Math.max(k - num2Arr.length + 1, 0); i < num1Arr.length && i <= k; i++) {
                sum += num1Arr[i] * num2Arr[k - i];
            }

            result[k] = sum % 10;
            carry = sum / 10;
        }

        // deliberately adding the last carry here
        result[result.length - 1] = carry;

        return arrayToString(result);
    }

    private int[] stringToArray(String num) {
        int[] arr = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            arr[num.length() - i - 1] = charToInt(num.charAt(i));
        }

        return arr;
    }

    private int charToInt(char c) {
        return (int)(c - '0');
    }

    private String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();

        // skip the leading zero: only can happen for the first digit, when there is no carry
        if (arr[arr.length - 1] != 0) {
            sb.append(arr[arr.length - 1]);
        }

        // the first digit is handled, now loop through the rest
        for (int i = arr.length - 2; i >= 0; i--) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "789";
        String str2 = "567";

        Solution s = new Solution();

        System.out.println(s.multiply(str1, str2));
    }
}
