Given an `m x n` matrix `board` containing `X` and `0`, capture all regions that are 4-directionally surrounded by `X`.

A region is captured by flipping all `0`s into `X`s in that surrounded region.

Examples:
```
Input: board = [
["X","X","X","X"],
["X","O","O","X"],
["X","X","O","X"],
["X","O","X","X"]
]
Output: [
["X","X","X","X"],
["X","X","X","X"],
["X","X","X","X"],
["X","O","X","X"]
]

Input: board = [
["X"]
]
Output: board = [
["X"]
]
```
* Note that an `O` should not be flipped if:
  * It is on the border, or
  * It is adjacent to an `0` that should not be flipped

Constraints:
* `m == board.length`
* `n == board[i].length`
* `1 <= m, n <= 200`
* board[i][j] is `X` or `O`
