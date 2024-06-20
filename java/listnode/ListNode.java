package com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode;

/**
 * Pure implementation of ListNode
 * straight from LeetCode,
 * with toString method added.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

}
