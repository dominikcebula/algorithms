# Knapsack Problem

## Description

The goal is to calculate the maximum profit of items that can be placed in a bag with a specified capacity. Each item
has an associated profit and weight.

Given `profits`, `weights`, `itemCount`, and `bagCapacity`, the task is to find the maximum profit achievable by
selecting all or a
subset of items that can fit into the bag without exceeding its capacity.

Items can either be fully included in the bag or not included at all.

## Input

* `profits[]` - an array of integers representing the profit of each item
* `weights[]` - an array of integers representing the weight of each item
* `itemCount` - an integer representing the number of items
* `bagCapacity` - an integer representing the maximum weight the bag can hold

## Output

* A single integer representing the maximum profit that can be obtained without exceeding the bag's capacity

## Examples

### Example 1

* Input:
  * `profits[] = [1, 2, 3]`
  * `weights[] = [4, 5, 1]`
  * `itemCount[] = 3`
  * `bagCapacity[] = 4`
* Output: `3`
* Explanation: The bag has a capacity of 4. There are only two items that can fit into the bag. The first item has a
  weight of 4 and a profit of 1. After selecting this item, there will be no remaining capacity to add any other items,
  so the final profit will be 1. The second item cannot fit into the bag, even by itself, because its weight exceeds the
  bag's capacity. We can choose the third item instead, which has a profit of 3 and leaves the bag with a remaining
  capacity of 3. However, this remaining capacity does not allow for any additional items to be added. Therefore, the
  final profit is 3, which is the maximum profit achievable in this scenario.

### Example 2

* Input:
  * `profits[] = [20, 30, 50, 10]`
  * `weights[] = [3, 4, 5, 2]`
  * `itemCount[] = 4`
  * `bagCapacity[] = 8`
* Output: `70`
* Explanation: Selecting first and third item will yield the highest profit. Bag capacity is 8, total weight of first
  and third item is also 8 with the profit 70.

### Example 3

* Input:
  * `profits[] = [7, 2, 9, 4]`
  * `weights[] = [3, 1, 2, 1]`
  * `itemCount[] = 4`
  * `bagCapacity[] = 5`
* Output: `16`
* Explanation: Selecting first and third items will yield the highest profit.
