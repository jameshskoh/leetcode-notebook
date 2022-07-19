There is an integer array `nums` sorted in ascending order (with distinct values).

Prior to being passed to your function, `nums` is possibly rotated at an unknown pivot index `k` (`1 <= k < nums.length`) such that the resulting array is `[nums[k], nums[k+1], ... nums[n-1], nums[0], nums[1], ... nums[k-1]]` (0-indexed). For example, `[0, 1, 2, 4, 5, 6, 7]` might be rotated at pivot index `3` and become `[4, 5, 6, 7, 0, 1, 2]`.

Given the array `nums` after the possible rotation and an integer `target`, return the index of `target` if it is in `nums`, or `-1` if it is not in `nums`.

You must write an algorithm with $O(log n)$ runtime complexity.



#### Examples

```
Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
Output: 4
```

```
Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 3
Output: -1
```

```
Input: nums = [1], target = 0
Output: -1
```



#### 1. Questions

* $1 \leq nums.length \leq 5000$
* $-10^4 \leq nums[i] \leq 10^4$
* All values of `nums` are unique
* `nums` is an ascending array that is possibly rotated
* $-10^4 \leq target \leq 10^4$



#### 2. An Example



#### 3. An Initial Solution

* Use a binary search to find the pivot
  * Since the array is strictly increasing except at the original endpoint of the array
  * Use binary search to find the shifted index
* Use a binary search with index translation

```java
public int search(int[] nums, int target) {
	int lb = 0;
    int ub = nums.length - 1;
    int pivot = 0;
    
    if (nums[lb] > nums[ub]) {
        while (lb < ub - 1) {
            int mid = (lb + ub) / 2;

            if (nums[lb] < nums[mid]) {
                lb = mid;
            } else if (nums[ub] > nums[mid]) {
                ub = mid;
            }
        }

        pivot = ub;
    } else {
        pivot = 0;
    }
    
    
    lb = 0;
    ub = nums.length - 1;
    
    while (lb <= ub) {
        int mid = (lb + ub) / 2;
        int midShift = shift(mid, pivot, nums);
        
        if (nums[midShift] == target) {
            return midShift;
        } else if (nums[midShift] < target) {
            lb = mid + 1;
        } else {
            ub = mid - 1;
        }
    }
    
    return -1;
}

private int shift(int index, int pivot, int[] nums) {
    return (index + nums.length + pivot) % nums.length;
}
```

* This solution is $O(\log n)$



#### 4. Test The Solution



#### 5. Iterate Through Your Solution

* There is no other way faster than this




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

