# Longest Common Subsequence

## Description

Given two strings, find Longest Common Subsequence (LCS) present in both strings. Longest Common Subsequence does not
necessary need to be continuous.

For example given two strings `XRYZW` and `XVYFZ`, Longest Common Subsequence will be `XYZ`.

## Input

* `string1` - string - first given string
* `string2` - string - second given string

## Output

* a single integer number representing length of Longest Common Subsequence

## Examples

### Example 1

* Input: `ABC` and `ACD`,
* Output: `2`
* Explanation: the Longest Common Subsequence is `AC`

### Example 2

* Input: `ABCBDAB` and `BDCAB`,
* Output: `4`
* Explanation: the Longest Common Subsequence is `BDAB`

### Example 3

* Input: `ABCDXYWZEFGH` and `XYZEFGHABCD`,
* Output: `7`
* Explanation: the Longest Common Subsequence is `XYZEFGH`
