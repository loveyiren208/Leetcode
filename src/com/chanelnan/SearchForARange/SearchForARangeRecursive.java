package com.chanelnan.SearchForARange;

import java.util.Arrays;

/**
 * Search for a Range
 * https://leetcode.com/problems/search-for-a-range/
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * Recursive solution: the worse case is n, when the array is full of target number
 * Created by Vivian on 3/15/15.
 */
public class SearchForARangeRecursive {
    public int[] searchRange(int[] A, int target) {
        int[] result = searchHelper(A, 0, A.length, target);
        if(result[1] == -1) {
            return result;
        } else {
            result[1] = result[1] - 1;
            return result;
        }
    }

    private int[] searchHelper(int[] A, int start, int end, int target){
        if (end - start == 1) {
            if (A[start] == target) {
                return new int[]{start, end};
            } else {
                return new int[]{-1, -1};
            }
        }
        if (A[start] > target || A[end - 1] < target) {
            return new int[]{-1, -1};
        }
        int middle = (end + start)/2;
        int[] first = searchHelper(A, start, middle, target);
        int[] second = searchHelper(A, middle, end, target);
        if (first[1] == -1) {
            return second;
        } else if (second[1] == -1) {
            return first;
        } else {
            return new int[]{first[0], second[1]};
        }
    }
}
