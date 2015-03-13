package com.chanelnan.Median;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Median of Two Sorted Arrays
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Good solution!!
 * Created by Vivian on 3/13/15.
 */
public class GoodMedian {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length1 = A.length;
        int length2 = B.length;

        if ((length1 + length2) % 2 != 0) {
            return (double)findKth(A, 0, length1, B, 0, length2, (length1 + length2 + 1) / 2);
        } else {
            return (double) (findKth(A, 0, length1, B, 0, length2, (length1 + length2) / 2 )
                    + findKth(A, 0, length1, B, 0, length2, (length1 + length2) / 2 + 1) ) / 2;
        }
    }

    public int findKth(int A[], int a1, int a2, int B[], int b1, int b2, int k) {
        if ( (a2 - a1) > (b2 - b1) ) {
            return findKth(B, b1, b2, A, a1, a2, k);
        }
        if (a2 == a1) {
            return B[b1 + k - 1];
        }
        if (k == 1 ) {
            return Math.min(A[a1], B[b1]);
        }

        int aCount = Math.min(a2 - a1, k/2);
        int bCount = k - aCount;

        if (A[a1 + aCount -1] < B[b1 + bCount - 1]) {
            return findKth(A, a1 + aCount, a2, B, b1, b1 + bCount, k - aCount);
        }else {
            return findKth(A, a1, a1 + aCount, B, b1 + bCount, b2, k - bCount);
        }
    }
}
