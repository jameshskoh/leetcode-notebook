Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that `i != j`, `i != k`, `j != k` and `nums[i] + nums[j] + nums[k] == 0`.

Examples:
```
Input: nums = [-1, 0, 1, 2, -1, -4]
Output: [[-1, -1, 2], [-1, 0, 1]]

Input: nums = [0, 1, 1]
Output: []

Input: nums = [0, 0, 0]
Output: [[0, 0, 0]]
```

Constraints:
* `3 <= nums.length <= 3000`
* `-10^5 <= nums[i] <= 10^5`

Solution
1. What if we sort the array first?
2. Binary sort: O(n log n)
3. Start with a pointer A, go from left to right, repeat n times
4. For each A, let other two pointers B, C close into each other to look for solution: should take O(n) each
5. Total time complexity O(n^2), O(1) extra space, performance likely better as around 1/2 of the comparisons are skipped

* Dealing with edge cases
* E.g. -1 -1 0 1 2 3
* 1 2 5 would be an answer
* 1 3 4 would be an answer
* 2 3 4 would be an answer too, but is a duplicate to 1 3 4
* The trick is to recognize that for pt1, if its previous value is equal, it has traverse the same combinations before, and can be skipped
* pt2 would have the similar situation, if it finds that the previous value is equal (and the previous value is not currently occupied by pt1), then it has traversed through the same combinations before and can be skipped.
