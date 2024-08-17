# Palindrome Partitioning

## Description

Given a string, find minimum number of cuts required to partition string into palindromes.

After cuts are applied, each substring should be a palindrome. String of length one is considered a palindrome.

## Input

* A single string

## Output

* A single integer number representing minimum number of cuts required to partition string into palindromic substrings

## Examples

### Example 1

* Input: `abba`
* Output: 0
* Explanation: Input string is already a palindrome, no cuts are required

### Example 2

* Input: `abbac`
* Output: 1
* Explanation: Only one cut is required: `abba|c`. This cut will create two substrings, `abba` and `c`. Both are
  palindromes.

### Example 3

* Input: `peek`
* Output: 2
* Explanation: Two cuts are required: `p|ee|k`. This will create one two character string `ee`, and then single
  characters strings `p` and `k`. All are palindromes.

### Example 4

* Input: `abbacddc`
* Output: 2
* Explanation: Two cuts are required: `abba|cddc`. This will create two substrings `abba` and `cddc`.

### Example 4

* Input: `abcdefgh`
* Output: 7
* Explanation: Seven cuts are required: `a|b|c|d|e|f|g|h`. Those cuts will create one letter strings, and each one
  letter string is also a palindrome.
