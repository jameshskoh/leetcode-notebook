Given two strings `s1` and `s2`, return `true` if `s2` contains a permutation of `s1`, or `false` otherwise.

In other words, return `true` if one of `s1`'s permutations is the substring of `s2`.

Examples:
```
Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba")

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
```

Constraints:
* `1 <= s1.length, s2.length <= 10^4`
* `s1` and `s2` consist of lowercase English letters

Solution:
* We do not care about the order of the substring
* We care about the number of certain character in the substring
1. Populate charFreqs of s1
2. Set pt1 and pt2 for s2, signaling the start and end of the substring
3. If charFreq[char(pt2)] > cumCharFreqs[char(pt2)], add the character, move pt2 forward, subCount++;
4. If char(pt2) does not exist, you don't need this character, reset all cumCharFreqs to 0, subCount = 0, set pt1, pt2 to the next char
5. If char(pt2) exists, but has too much of it, you need to let pt1 retract until it discard the previous same char
6. If subCount = s1.length, exit, return true
7. If subCount != s1.length and reached the end, return false

* This is O(n) as both pt1 and pt2 will at most traverse through the whole string once, cumCharFreqs will also be incremented, decremented in O(n)
* While this algorithm has an optimal time complexity, it looks messy, likely has a cleaner solution
