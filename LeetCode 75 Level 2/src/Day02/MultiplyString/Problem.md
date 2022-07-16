Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.



Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



#### Example 1

```
Input: "2" and "3"
Output: "6"
```

```
Input: "123" and "456"
Output: "56088"
```



#### 1. Questions

* Integers?
  * Digits only
* Length?
  * $1 \leq num1.length, num2.length \leq 200$
* Both do not contain leading zero, except for number `0`



#### 2. An Example



#### 3. An Initial Solution

* Create a function that converts char to int
  * `int charToInt(char c)`
  * `return (int)(c - '0')`
* Store each of the strings into `int[]`
  * Where the lowest index stores the most insignificant value
* Create an `int[]` that has
  * Length $lenTotal = len1 + len2$
  * Where $len1$ is length of first, $len2$ is length of second
* Calculate
  * For $k: 0 \rightarrow lenTotal$
    * Take in a carry (0 when $k = 0$)
    * `sum += carry`
    * For $i: 0 \rightarrow len1$
      * `sum += first[i] * second[k - i]`
    * `result[k] = sum % 10`
    * `carry = sum / 10`
* Return the calculated value as string
  * Using a for loop and `StringBuilder`



#### 4. Test The Solution

```java
public String multiply(String num1, String num2) {
    // edge cases, 0 or 1
    if (num1.equals("0")) {
        return "0";
    } else if (num1.equals("1")) {
        return num2;
    } else if (num2.equals("0")) {
        return "0";
    } else if (num2.equals("1")) {
        return num1;
    }

    int[] num1Arr = stringToArray(num1);
    int[] num2Arr = stringToArray(num2);

    int[] result = new int[num1Arr.length + num2Arr.length];

    int carry = 0;
    // the last k: k = result.length - 1 can only be found from carry
    // looping through it would give index out of bound exception
    for (int k = 0; k < result.length - 1; k++) {
        int sum = carry;

        for (int i = 0; i < num1Arr.length && i <= k; i++) {
            if (k - i < num2Arr.length) {
                sum += num1Arr[i] * num2Arr[k - i];
            }
        }

        result[k] = sum % 10;
        carry = sum / 10;
    }

    // deliberately adding the last carry here
    result[result.length - 1] = carry;

    return arrayToString(result);
}

private int[] stringToArray(String num) {
    int[] arr = new int[num.length()];

    for (int i = 0; i < num.length(); i++) {
        arr[num.length() - i - 1] = charToInt(num.charAt(i));
    }

    return arr;
}

private int charToInt(char c) {
    return (int)(c - '0');
}

private String arrayToString(int[] arr) {
    StringBuilder sb = new StringBuilder();

    // skip the leading zero: only can happen for the first digit, when there is no carry
    if (arr[arr.length - 1] != 0) {
        sb.append(arr[arr.length - 1]);
    }

    // the first digit is handled, now loop through the rest
    for (int i = arr.length - 2; i >= 0; i--) {
        sb.append(arr[i]);
    }

    return sb.toString();
}
```

* Pitfall: multiplication calculation
  * For $k$
    * Multiplication only happens when $k: 0 \rightarrow k_{max} - 1$ where $k_{max} = result.length - 1$
    * For $k = k_{max}$, no multiplication occurs, it only stores the previous carry
  * For $i$ and the hidden $j$ where $j = k - i$
    * Constraint 1: $i \leq i_{max}$, where $i_{max} = arr1.length - 1$
    * Constraint 2: $i \leq k$
    * Constraint 3: $j \leq k$
  * For constraint 1 and constraint 2
    * For loop range $i = 0, i \leq k \land i \leq i_{max}$ 
  * For constraint 3
    * If statement, if $j > j_{max}$, skip



#### 5. Iterate Through Your Solution

* This solution is probably the fastest possible
* But the implementation took a lot of bug fixing
* Improvement
  * Constraint 3 can actually be encoded into the for loop, based on the starting value of $i$
  * $i_{min} = k - j_{max}$


```java
for (int k = 0; k < result.length - 1; k++) {
    int sum = carry;

    for (int i = Math.max(k - num2Arr.length + 1, 0); i < num1Arr.length && i <= k; i++) {
        sum += num1Arr[i] * num2Arr[k - i];
    }

    result[k] = sum % 10;
    carry = sum / 10;
}
```




#### 6. Implement The Code



#### 7. Walk Through and Test Implementation

