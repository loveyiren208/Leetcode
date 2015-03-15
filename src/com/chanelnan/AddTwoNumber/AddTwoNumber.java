package com.chanelnan.AddTwoNumber;

import com.chanelnan.commonClass.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Created by Vivian on 3/15/15.
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        ListNode header = current;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        // ********** YOU should NOT forget this!!!!!******
        if (carry != 0) {
            current.next = new ListNode(carry);
        }
        return header.next;
    }
}
