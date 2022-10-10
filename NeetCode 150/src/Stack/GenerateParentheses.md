Given `n` pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Examples:
```
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Input: n = 1
Output: ["()"]
```

Constraints:
* `1 <= n <= 8`

Solution:
* There cannot be more closing parentheses before opening parentheses
* Use recursion: given current total parentheses, decide either to add an opening parenthesis or a closing parenthesis
* recurse ->
  * if reached: add to result
  * else
    * if not enough open: open parenthesis
    * if close less than open: close parenthesis
* open parenthesis ->
  * create a new string with "(" appended
  * call recurse with increased open parentheses
* close parenthesis ->
  * create a new string with ")" appended
  * call recurse with increased close parentheses
* once done, return result

Concerns?
* Stack overflow? There will only be n-layer stacks at most
* Inefficiency? Each pattern is only traversed once
