package com.chanelnan.Median;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Median of Two Sorted Arrays
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * Created by Vivian on 3/13/15.
 */
public class Median {
    public double findMedianSortedArrays(int A[], int B[]) {
        int length1 = A.length;
        int length2 = B.length;
        if (length1 == 0) {
            if ( length2 % 2 != 0 ) {
                return (double)B[ (length2 + 1) / 2 - 1];
            } else {
                return (double)(B[length2/2 -1] + B[length2/2]) / 2;
            }
        }

        if (length2 == 0) {
            if ( length1 % 2 != 0 ) {
                return (double)A[ (length1 + 1) / 2 - 1];
            } else {
                return (double)(A[length1/2 -1] + A[length1/2]) / 2;
            }
        }

        if ((length1 + length2) % 2 != 0) {
            return (double)findKth(A, 0, length1 - 1, B, 0, length2 - 1, (length1 + length2 + 1) / 2);
        } else {
            return (double) (findKth(A, 0, length1 - 1, B, 0, length2 -1, (length1 + length2) / 2 )
                    + findKth(A, 0, length1 - 1, B, 0, length2 - 1, (length1 + length2) / 2 + 1) ) / 2;
        }
    }

    public int findKth(int A[], int a1, int a2, int B[], int b1, int b2, int k) {
        if ( (a2 - a1) > (b2 - b1) ) {
            return findKth(B, b1, b2, A, a1, a2, k);
        }

        if (b1 == b2) {
            if (k == 1) {
                return A[a1] > B[b1] ? B[b1] : A[a1];
            } else {
                return A[a1] >B[b1] ? A[a1] : B[b1];
            }
        }

        if (a2 == a1) {
            if ( B[b1 + k - 2] >= A[a1]) {
                return B[b1 + k - 2];
            } else {
                return A[a1] > B[b1 + k -1] ? B[b1 + k -1 ] : A[a1];
            }
        }

        int indexGap = (k+1)/2 - 1;

        if ( a2 <= a1 + indexGap) {
            int index2 = b1 + indexGap + a1 + indexGap - a2;
            if (A[a2] > B[index2]) {
                return findKth(A, a1, a2, B, index2, b2, k - (index2 - b1));
            } else if (A[a2] == B[index2]) {
                return A[a2];
            } else {
                return findKth(A, a2, a2, B, b1, index2, k - (a2 - a1));
            }
        }

        if (A[a1 + indexGap] == B[b1 + indexGap]) {
            return A[a1 + indexGap];
        } else if (A[a1 + indexGap] > B[b1 + indexGap]) {
            return findKth(A, a1, a1 + indexGap, B, b1 + indexGap, b2, k - indexGap );
        } else {
            return findKth(A, a1 + indexGap, a2, B, b1, b1 + indexGap, k - indexGap);
        }
    }
}
