Write an algorithm to determine if a number `n` is happy.

A **happy number** is a number defined by the following process:

* Starting with any positive integer, replace the number by the sum of the squares of its digits
* Repeat the process until the number equals 1 (where it will stay), or it **loops endlessly in a cycle** which does not include 1
* Those numbers for which this process **ends in 1** are happy

Return `true` if `n` is a happy number, and `false` if not



#### Example 1

```
Input: n = 19
Output: true
```

$$
1^2 + 9^2 = 82 \\
8^2 + 2^2 = 68 \\
6^2 + 8^2 = 100 \\
1^2 + 0^2 + 0^2 = 1
$$



#### Example 2

```
Input: n = 2
Output: false
```



#### 1. Questions

* If it does not reach 1, it will loop indefinitely? Like reaching a number, and coming back again?
  * Yes
* Positive integers only?
  * Yes



#### 2. An Example

* $34$ is not
  * As it will go through $89$ repeatedly



#### 3. An Initial Solution

* A function to break the integer into its parts
  * And calculate the sum of squares
* A hash map, that will record all past records
* When the sum of squares is calculated
  * Check if its 1
    * Return true
  * Check if it exists in the hash map
    * Yes: return false
    * No: continue
      * Better don't use recursion, use a while true loop



