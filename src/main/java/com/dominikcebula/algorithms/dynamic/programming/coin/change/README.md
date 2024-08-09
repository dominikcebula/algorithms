# Coin Change

## Description

Count all possible combinations of coin denominations that can be used to achieve a given sum.

Given an array of coin denominations and a target integer sum, implement an algorithm to count all the possible
combinations of coins that can be used to reach the given sum. Assume that you have an infinite supply of each type of
coin.

## Input

* `sum` - integer number - given value sum that should be achieved by using given coin denominations
* `coinDenominations[]` - array of integers - each number represents a different coin denomination

## Output

* a single integer number representing count of all combinations to make a given sum

## Examples

### Example 1

* Input: `sum` = `4`, `coinDenominations[]` = `[1,2,3]`
* Output: `4`
* Explanation: there are four solutions: `[1, 1, 1, 1]`, `[1, 1, 2]`, `[2, 2]`, `[1, 3]`

### Example 2

* Input: `sum` = `6`, `coinDenominations[]` = `[1,3,4]`
* Output: `6`
* Explanation: there are four solutions: `[1, 1, 1, 1, 1, 1]`, `[1, 1, 1, 3]`, `[1, 1, 4]`, `[3, 3]`

### Example 3

* Input: `sum` = `10`, `coinDenominations[]` = `[2, 5, 3, 6]`
* Output: `5`
* Explanation: There are five solutions: `[2,2,2,2,2]`, `[2,2,3,3]`, `[2,2,6]`, `[2,3,5]`, `[5,5]`
