# Longest Increasing Subsequence

## Description

Given an array of elements, calculate the length of the Longest Increasing Subsequence (LIS).

The Longest Increasing Subsequence is a sequence of elements in which each subsequent element is larger than the
previous one.

The sequence does not need to be continuous, and you can skip elements. For example, given the elements [1, -1, 2, 3],
the Longest Increasing Subsequence would be [1, 2, 3], which contains three elements by skipping -1.

The sequence can start and end at any element. For instance, given the elements [5, -2, 6, 1, 2, 3, -5], the Longest
Increasing Subsequence would be [-2, 1, 2, 3]. This sequence is created by starting at a non-first element, skipping the
third element, and finishing at a non-last element.

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
