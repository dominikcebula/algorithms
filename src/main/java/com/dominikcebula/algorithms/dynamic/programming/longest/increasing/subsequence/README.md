# Longest Increasing Subsequence

## Description

Given an array of elements, calculate length of Longest Increasing Subsequence.

Longest Increasing Subsequence is a sequence of elements in which each next element is larger than the previous element.

Sequence does not need to be continuous, you can skip elements, for example given elements `[1,-1,2,3]` the Longest
Increasing Subsequence will
be a sequence `[1, 2, 3]` that contains `3` elements created by skipping element `-1`.

Sequence can start and end at any element, for example, given elements `[5,-2,6,1,2,3,-5]`, then Longest Increasing
Subsequence will be `[-2, 1, 2, 3]`, that is created by starting with non-first element, skipping third element and
finishing with non-last element.

## Input

* `elements[]` - array of integers - sequence of numbers in which Longest Increasing Subsequence should be found

## Output

* a single integer number representing length of Longest Increasing Subsequence

## Examples

### Example 1

* Input: `elements[]` = `[3, 4, -1, 0, 6, 2, 3]`,
* Output: `4`
* Explanation: the Longest Increasing Subsequence is `[-1, 0, 2, 3]`

### Example 2

* Input: `elements[]` = `[3, 10, 2, 1, 20]`,
* Output: `3`
* Explanation: the Longest Increasing Subsequence is `[3, 10, 20]`

### Example 3

* Input: `elements[]` = `[10, 20, 35, 80]`,
* Output: `4`
* Explanation: the Longest Increasing Subsequence is `[10, 20, 35, 80]`
