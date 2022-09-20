There are a total of `numCourses` courses you have to take, labeled from `0` to `numCourses - 1`. You are given an array `prerequisites` where `prerequisites[i] = [a_i, b_i]` indicates that you must take course `b_i` first if you want to take course `a_i`.

For example, the pair `[0, 1]` indicates that to take course `0` you have to first take course `1`

Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



#### Examples

```
Input: numCourses = 2, prerequisites = [[1, 0]]
Output: [0, 1]

Input: numCourses = 4, prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
Output: [0, 1, 2, 3] or [0, 2, 1, 3]

Input: numCourses = 1, prerequisites = []
Output: [0]
```



#### Constraints

* `1 <= numCourses <= 2000`
* `0 <= prerequisites.length <= numCourses * (numCourses - 1)`
* `prerequisites[i].length == 2`
* `0 <= a_i, b_i < numCourses`
* `a_i != b_i`
* All pairs of `[a_i, b_i]` are distinct



#### 3. An Initial Solution



#### 4. Test The Solution



#### 5. Iterate Through Your Solution




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

