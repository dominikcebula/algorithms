# Rod Cutting

## Description

Determine the maximum value that can be obtained by cutting a rod of a given length into smaller pieces and selling
them. The price for each piece is provided in the `prices[]` array, where the `i`-th element represents the price for a
piece of length `i+1`. The length of the rod is equal to the size of the `prices[]` array.

## Input

* `prices[]` - array of integer, `i`-th element represents the price for a piece of length `i+1`

## Output

* a single integer representing the maximum value that can be obtained by cutting and selling rod into smaller pieces

## Examples

### Example 1

* Input: `price[] = [1, 5, 8, 9, 10, 17, 17, 20]`
* Output: `22`
* Explanation: Rod has lengths of `8`. Maximum value can be obtained by cutting rod into two pieces. First piece of size
  `6` would be sold for `17`, and second piece of size `2` would be sold for `5`. This will give maximum value of `22`.

### Example 2

* Input: `price[] = [3, 5, 8, 9, 10, 17]`
* Output: `18`
* Explanation: Rod has lengths of `6`. Maximum value can be obtained by cutting rod into six pieces. Each piece would
  have length of `1` and price of `3`. `6 * 3 = 18`, which is the maximum value that can be obtained.

### Example 3

* Input: `price[] = [1, 4, 6, 5]`
* Output: `7`
* Explanation: Rod has lengths of `4`. Maximum value of `7` can be obtained by cutting rod into two pieces. First piece
  would have length of `3` and would be sold for `6`. Second piece would have lengths of `1` and would be sold for `1`.
  This gives total value of `7`. 
