package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        recurse(n, 0, 0, result, "");

        return result;
    }

    private void recurse(int target, int open, int close,
                         List<String> result, String sub) {
        if (open == target && close == target) {
            result.add(sub);
        }

        if (open < target) {
            open(target, open, close, result, sub);
        }

        if (close < open) {
            close(target, open, close, result, sub);
        }
    }

    private void open(int target, int open, int close,
                      List<String> result, String sub) {
        String newSub = sub + "(";
        recurse(target, open + 1, close, result, newSub);
    }

    private void close(int target, int open, int close,
                       List<String> result, String sub) {
        String newSub = sub + ")";
        recurse(target, open, close + 1, result, newSub);
    }
}
