Given an `m x n` matrix, return all elements of the matrix in spiral order. 



#### Example 1

```
Input: n = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]
```

$$
\begin{matrix}
1 & 2 & 3 \\
4 & 5 & 6 \\ 
7 & 8 & 9 \\
\end{matrix}
$$



#### Example 2

```
Input: n = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
```

$$
\begin{matrix}
 1 &  2 &  3 &  4 \\
 5 &  6 &  7 &  8 \\ 
 9 & 10 & 11 & 12 \\
\end{matrix}
$$





#### 1. Questions

* The matrix is not necessarily a square
  * Yes
* The values contained is not necessarily related to their positions in the matrix
  * Yes
  * Could be between -100 and 100
* Assume only contains integer
  * OK
  * Just a small change to have double value
* No empty matrix
  * Yes
* Could be single row/single column matrix
  * Yes
* Right > Down > Left > Up > Right
  * For a single column matrix, it would go straight down



#### 2. An Example

```
Input: [1, 2, 3, 4, 5]
Output: [1, 2, 3, 4, 5]
```

```
Input: [[1], [2], [3], [4], [5]]
Output: [1, 2, 3, 4, 5]
```

```
Input: [[-10, 10], [5, -5]]
Output: [-10, 10, -5, 5]
```



#### 3. An Initial Solution

* I can access any of the element through `matrix[i][j]`
* Use a while loop
  * A for loop in it
    * Each time it traverse a value, add it to a list
      * The list can be array list and have insert $O(1)$
      * since we already know the size beforehand
  * The lower/upper bounds are important
  * Use minRow, maxRow, minCol, maxCol to keep track of them
    * Each time a for loop runs, update them
  * When the for loop reaches its end, switch direction



#### 4. Test The Solution

* Test passed



#### 5. Iterate Through Your Solution

* The previous method is actually very hard to implement
  * Why? Because the seemingly similar for loops are actually doing very different things
  * When creating the for loop, what are the lower and upper bounds?
  * When the for loop ends, how do we create another for loop
    * How do we know which direction the for loop will be traversing?

* A better way: **find the invariant** in this problem
  * Everything starts over again after we traverse through a round trip
  * Loop through this round trip, instead of focusing on the 4 loops

* **While loop is underrated**
  * Use a while loop to wrap around the 4 for loops




#### 6. Implement The Code

```java
int minRow = 0;
int maxRow = matrix.length;
int minCol = 0;
int maxCol = matrix[0].length;

ArrayList<Integer> result = new ArrayList<>(matrix.length * matrix[0].length);

while (minRow <= maxRow && minCol <= maxCol) {
    // go right
    for (int col = minCol; col <= maxCol; col++) {
        result.add(matrix[minRow][col]);
    }
    
    // top row is gone, minRow++
    minRow++;
    
    // go down
    for (int row = minRow; row <= maxRow; row++) {
        result.add(matrix[row][maxCol])
    }
    
    // right col is gone, maxCol--
    maxCol--;

    if (!(minRow <= maxRow && minCol <= maxCol)) {
        break;
    }
    
    // go left
    for (int col = maxCol; col >= minCol; col--) {
        result.add(matrix[maxRow][col])
    }
    
    // bottom row is gone, maxRow--
    maxRow--;
    
    // go up
    for (int row = maxRow; row >= minRow; row--) {
        result.add(matrix[row][minCol]);
    }
    
    // left col is gone, minCol++
    minCol++;
}

return result;
```



#### 7. Walk Through and Test Implementation

* It turns out when only either `minRow > maxRow`  or `minCol > maxCol` will be achieved at a time
  * I thought that the 3rd and 4th loop will not run anymore if these criteria are reached
  * Turns out one of them will run, as `minRow > maxRow` does not mean `minCol > maxCol` or vice versa
  * I have to add a if statement between 2nd and 3rd loop to check the while loop criteria again
* Takeaway: remind yourself whether the `while` guard is properly enforced throughout the code

