# Rod Cutting

## Description

Given list of activities, determine maximum amount of activities that a single person can attend. Each activity is
described by a start and end time. Activity is represented as `(start, end)`. A single person can only take a
single
activity at a time.

Two activities do not overlap each other if start time of the next activity is greater than end time of the current
activity.

## Input

* array of activities, each element of the array is given in a format `(start, end)`

## Output

* a single number representing maximum number activities that can be attended by a single person

## Examples

### Example 1

* Input: `(1,3), (4,6)`
* Output: `2`
* Explanation: Each activity can be taken because none of the activities overlap

### Example 2

* Input: `(2,4), (6,8), (5,9)`
* Output: `2`
* Explanation: Only two activities can be taken. First solution is to use `(2,4), (6,8)`, second solution is to use
  `(2,4), (5,9)`. `(6,8), (5,9)` cannot be used because they are overlapping with each other.

### Example 3

* Input: `(1,3), (3,5), (5,7), (7,9)`
* Output: `2`
* Explanation: There are only two sets of non-overlapping activities. `(1,3), (5,7)` or `(3,5), (7,9)`. 
