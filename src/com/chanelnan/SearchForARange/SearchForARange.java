package com.chanelnan.SearchForARange;

/**
 * Good solution!!
 * O(lgn)
 * Created by Vivian on 3/16/15.
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int start = 0;
        int end = A.length;
        int[] result = new int[]{-1, -1};
        while (start < end) {
            int curse = (start + end)/2;
            if (A[curse] > target) {
                end = curse;
            } else if(A[curse] < target) {
                start = curse + 1;
            } else {
                int r1 = -1;
                int s1 = start;
                int e1 = curse;
                while (s1 < e1) {
                    int cur = (s1 + e1) / 2;
                    if (A[cur] == target) {
                        e1 = cur;
                        r1 = cur;
                    } else {
                        s1 = cur + +1;
                    }
                }
                result[0] = r1 == -1 ? curse : r1;

                r1 = -1;
                s1 = curse + 1;
                e1 = end;
                while (s1 < e1) {
                    int cur = (s1 + e1) / 2;
                    if (A[cur] == target) {
                        s1 = cur + 1;
                        r1 = cur;
                    } else {
                        e1 = cur;
                    }
                }
                result[1] = r1 == -1 ? curse : r1;
                return result;
            }
        }
        return result;
    }
}
