[![CI Pipeline](https://github.com/dominikcebula/algorithms/actions/workflows/maven.yml/badge.svg)](https://github.com/dominikcebula/algorithms/actions/workflows/maven.yml)

<!-- TOC -->

* [Introduction](#introduction)
* [Algorithms](#algorithms)
    * [Dynamic Programming Algorithms](#dynamic-programming-algorithms)
        * [Knapsack Problem](#knapsack-problem)
        * [Coin Change](#coin-change)
        * [Rod Cutting](#rod-cutting)
        * [Subset Sum](#subset-sum)
        * [Longest Increasing Subsequence](#longest-increasing-subsequence)
        * [Longest Common Subsequence](#longest-common-subsequence)
        * [Longest Palindromic Subsequence](#longest-palindromic-subsequence)
        * [Min Cost Path](#min-cost-path)
        * [Palindrome Partitioning](#palindrome-partitioning)
    * [Greedy Algorithms](#greedy-algorithms)
        * [Activity Selection](#activity-selection)
* [Data Structures](#data-structures)
    * [Heap](#heap)
    * [Binary Search Tree](#binary-search-tree)
    * [Linked List](#linked-list)
    * [Stack](#stack)
* [Author](#author)

<!-- TOC -->

# Introduction

This repository contains sample Algorithms & Data Structures.

# Algorithms

## Dynamic Programming Algorithms

### Knapsack Problem

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fknapsack%2Fproblem%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fknapsack%2Fproblem%2FKnapsackProblemRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fknapsack%2Fproblem%2FKnapsackProblemMemoization.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fknapsack%2Fproblem%2FKnapsackProblemTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fknapsack%2Fproblem%2FKnapsackProblemTest.java)

### Coin Change

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fcoin%2Fchange%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fcoin%2Fchange%2FCoinChangeRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fcoin%2Fchange%2FCoinChangeMemoization.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fcoin%2Fchange%2FCoinChangeTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fcoin%2Fchange%2FCoinChangeTest.java)

### Rod Cutting

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Frod%2Fcutting%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Frod%2Fcutting%2FRodCuttingRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Frod%2Fcutting%2FRodCuttingMemoization.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Frod%2Fcutting%2FRodCuttingTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Frod%2Fcutting%2FRodCuttingTest.java)

### Subset Sum

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fsubset%2Fsum%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fsubset%2Fsum%2FSubsetSumRecursion.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fsubset%2Fsum%2FSubsetSumTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fsubset%2Fsum%2FSubsetSumTest.java)

### Longest Increasing Subsequence

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fincreasing%2Fsubsequence%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fincreasing%2Fsubsequence%2FLongestIncreasingSubsequenceRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fincreasing%2Fsubsequence%2FLongestIncreasingSubsequenceMemoization.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fincreasing%2Fsubsequence%2FLongestIncreasingSubsequenceTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fincreasing%2Fsubsequence%2FLongestIncreasingSubsequenceTest.java)

### Longest Common Subsequence

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fcommon%2Fsubsequence%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fcommon%2Fsubsequence%2FLongestCommonSubsequenceRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fcommon%2Fsubsequence%2FLongestCommonSubsequenceMemoization.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fcommon%2Fsubsequence%2FLongestCommonSubsequenceTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fcommon%2Fsubsequence%2FLongestCommonSubsequenceTest.java)

### Longest Palindromic Subsequence

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fpalindromic%2Fsubsequence%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fpalindromic%2Fsubsequence%2FLongestPalindromicSubsequenceRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fpalindromic%2Fsubsequence%2FLongestPalindromicSubsequenceMemoization.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fpalindromic%2Fsubsequence%2FLongestPalindromicSubsequenceTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Flongest%2Fpalindromic%2Fsubsequence%2FLongestPalindromicSubsequenceRecursionTest.java)

### Min Cost Path

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fmin%2Fcost%2Fpath%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fmin%2Fcost%2Fpath%2FMinCostPathRecursion.java)
* [Solution - Memoization](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fmin%2Fcost%2Fpath%2FMinCostPathTabulation.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fmin%2Fcost%2Fpath%2FMinCostPathMemoization.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fmin%2Fcost%2Fpath%2FMinCostPathTest.java)

### Palindrome Partitioning

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fpalindrome%2Fpartitioning%2FREADME.md)
* [Solution - Recursion](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fpalindrome%2Fpartitioning%2FPalindromePartitioningRecursion.java)
* [Solution - Tabulation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fpalindrome%2Fpartitioning%2FPalindromePartitioningTabulation.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fdynamic%2Fprogramming%2Fpalindrome%2Fpartitioning%2FPalindromePartitioningRecursionTest.java)

## Greedy Algorithms

### Activity Selection

* [Description](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fgreedy%2Factivity%2Fselection%2FREADME.md)
* [Solution](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fgreedy%2Factivity%2Fselection%2FActivitySelection.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Falgorithms%2Fgreedy%2Factivity%2Fselection%2FActivitySelectionTest.java)

# Data Structures

## Heap

* [Implementation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Fheap%2FHeap.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Fheap%2FHeapTest.java)

## Binary Search Tree

* [Implementation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Ftree%2FBinarySearchTree.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Ftree%2FBinarySearchTreeTest.java)

## Linked List

* [Implementation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Flist%2FLinkedList.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Flist%2FLinkedListTest.java)

## Stack

* [Implementation](src%2Fmain%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Fstack%2FStack.java)
* [Tests](src%2Ftest%2Fjava%2Fcom%2Fdominikcebula%2Fdata%2Fstructures%2Fstack%2FStackTest.java)

# Author

Dominik Cebula

* https://dominikcebula.com/
* https://blog.dominikcebula.com/
* https://www.udemy.com/user/dominik-cebula/
