Given an array of strings `strs`, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Examples:
```
Input: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
Output: [["bat"], ["nat", "tan"], ["ate", "eat"], "tea"]

Input: strs = [""]
Output: [[""]]

Input" strs = ["a"]
Output: [["a"]]
```

Constraints:
* `1 <= strs.length <= 10^4`
* `0 <= strs[i].length <= 100`
* `strs[i]` consists of lowercase English letters

Solution
* Assume number of strings = m, string length = n
1. Sort each string in alphabetical order: O(m * n log n)
2. Take each sorted string as key, put (sorted string -> List<string>) into HashMap: O(n)
3. Iterate over the HashMap: O(n)
4. Time complexity: O(m * n log n), extra space complexity: O(m * n)

Can we do better?
* We don't really need to sort the array, all we need is the frequency information, which could each be retrieved within O(n)
1. Calculate character frequency of each string, store it in an ArrayList: O(m * n)
2. Take each ArrayList as key, put (ArrayList -> List<String>) into HashMap: O(n)
3. Iterate over the HashMap: O(n)
4. Time complexity: O(m * n), extra space complexity: O(m * n)

* While this has a better time complexity, it actually performed worse in benchmark.
