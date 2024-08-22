# Subset Sum

## Description

Given set of numbers and expected sum, write a program that checks if expected sum can be created using given set of
numbers.

## Input

* `elements[]` - array of integers - set of numbers which needs to be checked if given sum can be created using those
  numbers
* `sum` - single integer number - expected sum that should be created using given set of numbers

## Output

* single boolean value indicating if given sum can be created using given numbers

## Examples

### Example 1

* Input: `elements = [5, 12, 18, 25]`, `sum` = `37`
* Output: `true`
* Explanation: `37` can be created by adding `25` and `12`

### Example 2

* Input: `elements = [7, 9, 13, 21]`, `sum` = `20`
* Output: `true`
* Explanation: `20` can be created by adding `7` and `13`

### Example 3

* Input: `elements = [4, 6, 14, 21, 26]`, `sum` = `11`
* Output: `false`
* Explanation: `11` cannot be created using any given values
