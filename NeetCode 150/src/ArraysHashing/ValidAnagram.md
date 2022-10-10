Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Examples:
```
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false
```

Constraints:
* `1 <= s.length, t.length <= 5 * 10^4`
* `s` and `t` consist of lowercase English letters

1. Record the frequency of each character in a HashMap: O(n)
2. Since there are only lowercase characters, we can actually use an int[26] in place of the HashMap
3. Once all frequency of the characters are recorded, compare the frequencies of the two strings: O(n)
