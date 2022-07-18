Given a characters array `tasks`, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer `n` that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least `n` units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.



#### Examples

```
Input: tasks = [A, A, A, B, B, B], n = 2
Output: 8
Could be [A, B, i, A, B, i, A, B]
```

```
Input: tasks = [A, A, A, B, B, B], n = 
Output: 6
Could be [A, B, A, B, A, B]
```

```
Input: tasks = [A, A, A, A, A, A, B, C, D, E, F, G], n = 2
Output: 16
Could be [A, B, C, A, D, E, A, F, G, A, i, i, A, i, i, A]
```



#### 1. Questions

* $1 \leq task.length \leq 10^4$
* $tasks[i]$ is upper-case English letter
* `n` is in the range `[0, 100]`



#### 2. Examples

```
Input: tasks = [A, A, A, A, A], n = 2
Output: 13
Could be [A, i, i, A, i, i, A, i, i, A, i, i, A]
```



#### 3. An Initial Solution

* When a task runs significantly more frequently, it will dictate the CPU time
  * With a lot of idle time
  * How does it dictate?
    * If its in-between time is larger than the number of other tasks 
* Minimum time needed to finish $A$, the most frequently run task

$$
t_A = q_A + n \times (q_A - 1)
$$

* The in-between time of $A$

$$
n \times (q_A - 1)
$$

* If most tasks run almost equally frequently, the CPU will be always occupied
  * Calculating the total number of tasks will do

* Create a `int[26]` to fill the 26 upper-case English letters
* For each task, populate into `int[]`
* For each value in `int[]`
  * Find max, find sum
* If $sum - q_A \leq n \times (q_A - 1)$, return $t_A$, else return $sum$



#### 4. Test The Solution

* It fails when there are multiple tasks that has to be done $max$ times
  * Compensate those missing times
* Still fails
* Consider those equally frequent $max$ tasks stacked together
  * How much idle time is still available?
  * Compare this idle time and reconstruct the inequality
* Terminology
  * In-between interval: $n$
  * Most frequently run tasks: $max$
  * Frequency of the most frequently run task: $q_{max}$
  * Number of most frequently run tasks: $n_{max}$
  * Minimum time required by the most: $t_{max}$
  * Idle time required by only running the most frequently run tasks: $t_i$
  * Running time required by other processes: $t'$
  * Total runtime: $sum$


$$
t_{max} = n_{max} \times q_{max} + t_i
$$

$$
t_i = \max((q_{max} - 1)(n + 1 - n_{max}), 0)
$$

$$
t' = sum - n_{max} \times q_{max}
$$

* $n_{max} \times q_{max}$ is the total runtime required by $max$
* $t_i$ describes the in-between time required
  * If $n_{max} < n + 1$ , there would be in-between idle time
  * Else, there will not be

* For $t'$
  * If $t' > t_i$, there will not be any idle time, total time is $sum$
  * Else, there will be idle time, and total time will be dictated by $t_{max}$
* With some algebra, you can find that it's a comparison between $sum$ and $t_{max}$



#### 5. Iterate Through Your Solution

```java
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] hash = new int[26];
        
        for (char task : tasks) {
            hash[(int)(task - 'A')]++;
        }
        
        int max = 0;
        int sum = 0;
        
        for (int val : hash) {
            sum += val;
            
            if (max < val) {
                max = val;
            }
        }
        
        if (n == 0) return sum;
        
        int maxQty = 0;
        for (int val : hash) {
            if (val == max) maxQty++;
        }
        
        int temp = ((n + 1) - maxQty) * (max - 1);
        
        int idleLeft = (temp > 0 ? temp : 0);
        
        int tmax = idleLeft + max * maxQty;
        
        return (sum > tmax ? sum : tmax);
    }
}
```




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

