A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backwards. Alphanumeric characters include letters and numbers.

Given a string `s`, return `true` if it is a palindrome, or `false` otherwise.

Examples:
```
Input: s = "A man, a plan, a canal: Panama"
Output: true

Input: s = "race a car"
Output = false

Input s = " "
Output = true
```

Constraints:
* `1 <= s.length <= 2 * 10^5`
* `s` consists only of printable ASCII characters

Solution:
* Take two pointers, one at each end
* As long as the pointer does not sit on an alphanumeric character, iterate in
* When it reaches an alphanumeric character, record it and compare with the result of the other pointer
  * If any comparison fails, return false
* If the two pointers meet (or cross each other), exit loop and return true

* This solution takes O(n) time with O(1) extra space
