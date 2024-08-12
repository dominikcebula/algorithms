# Longest Common Subsequence

## Description

Given a cost matrix `costs[][]` and a target position `(M, N)` within the matrix, write a function to determine the
minimum
cost required to reach position `(M, N)` starting from `(0, 0)`. Each cell in the matrix contains a traversal cost. The
total cost of a path to `(M, N)` is calculated by summing the costs of all cells along the path, including both the
starting and ending cells. Movement is allowed only to the right, downward, or diagonally to the lower-right from any
cell `(i, j)`, specifically to the cells `(i+1, j)`, `(i, j+1)`, and `(i+1, j+1)`. All costs are positive integers.

## Input

* `costs[][]` - array of integers - matrix represents a cost at given position
* `(M, N)` - pair of integers - place in matrix that should be reached starting from `(0, 0)`

## Output

* a single integer number representing minimum cost required to traverse from `(0, 0)` to `(M, N)`

## Examples

### Example 1

Given `costs[][]`

```
1  2  5
3  2  1
4  2  2
```

and given `(M, N) = (2, 2)`

The minimum cost will be `5 = 1 + 2 + 2`.

### Example 2

Given `costs[][]`

```
1  2  5
3  9  1
4  2  2
```

and given `(M, N) = (2, 2)`

The minimum cost will be `6 = 1 + 2 + 1 + 2`.

### Example 3

Given `costs[][]`

```
5 9 3 8 2
7 1 6 4 9
3 2 5 7 1
8 3 6 9 4
4 1 8 2 7
```

and given `(M, N) = (2, 2)`

The minimum cost will be `23 = 5 + 1 + 2 + 6 + 2 + 7`.
