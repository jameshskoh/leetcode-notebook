Given an array of integers `nums` and an integer `target`, return indices of the two numbers such that they add up to `target`.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Examples:
```
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]

Input: nums = [3, 2, 4], target = 6
Output: [1, 2]

Input: nums = [3, 3], target = 6
Output: [0, 1]
```

Constraints
* `2 <= nums.length <= 10^4`
* `-10^9 <= nums[i] <= 10^9`
* `-10^9 <= target <= 10^9`
* One and only one valid answer exists

1. Make sure the search won't overlap: use two pointers
2. First pointer is the first operand, will traverse through the whole list
3. Second pointer is always after the first pointer, traverse through the array to find for the matching value

Follow-up: an algorithm less than O(n^2) time complexity?

1. Each value has a known complement
2. What we need to know is if this complement exists, we can use a O(1) query in place of the linear search
3. For each value, if itself is found in the HashMap, return its index and the index stored in the HashMap 
4. Else, calculate its complement and save in a HashMap (complement -> itself)
