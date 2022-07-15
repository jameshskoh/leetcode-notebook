Write a function to find the longest common prefix string amongst an array of strings.



If there is no common prefix, return an empty string `""`



#### Example 1

```
Input: strs = ["flower", "flow", "flight"]
Output: "fl"
```



#### Example 2

```
Input: strs = ["dog", "racecar", "car"]
Output: ""
No common prefix
```



#### 1. Questions

* How many strings do I need to compare?
  * $1 \leq strs.length \leq 200$
  * There will be at least one string
* How long can each string be?
  * $0 \leq strs[i].length \leq 200$
* Comparing cases?
  * `strs[i]` only has lowercase English letters



#### 2. An Example

```
Input: strs = ["", "a", "aa"]
Output: ""
```



#### 3. An Initial Solution

* Create a StringBuilder `sb`
* Get the shortest string length
* For the 0th character up until the shortest string length
  * Set `firstChar = strs[0].charAt(i)` 
  * For each subsequent string
    * Compare the character with `firstChar`
    * Mismatch? Exit
  * Add the character to `sb`
* Return `sb.toString()`



#### 4. Test The Solution

```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
        return strs[0];
    }
    
    int minLength = shortestStringLength(strs);
    StringBuilder sb = new StringBuilder();
    
    outerloop:
    for (int i = 0; i < minLength; i++) {
        char firstChar = strs[0].charAt(i);
        
        for (int j = 1; j < strs.length; j++) {
            if (firstChar != strs[j].charAt(i))
                break outerloop;
        }
        
        sb.append(firstChar);
    }
    
    return sb.toString();
}

private int shortestStringLength(String[] strs) {
    int min = strs[0].length();
    
    for (int i = 1; i < strs.length; i++) {
        if (strs[i].length() < min)
            min = strs[i].length();
    }
    
    return min;
}
```



#### 5. Iterate Through Your Solution

* I actually do not need `StringBuilder`
* All I need is where the substring ends
  * I can return substring out of any of the strings

```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
        return strs[0];
    }
    
    int minLength = shortestStringLength(strs);
    
    int i = 0;
    outerloop:
    while (i < minLength) {
        char firstChar = strs[0].charAt(i);
        
        for (int j = 1; j < strs.length; j++) {
            if (firstChar != strs[j].charAt(i))
                break outerloop;
        }
        
        i++;
    }
    
    return strs[0].substring(0, i);
}

private int shortestStringLength(String[] strs) {
    int min = strs[0].length();
    
    for (int i = 1; i < strs.length; i++) {
        if (strs[i].length() < min)
            min = strs[i].length();
    }
    
    return min;
}
```




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

