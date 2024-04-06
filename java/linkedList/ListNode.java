package com.dkhapps.tasks.leetcode.java.debug;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    /**
     *  Return a number of nodes linked to this node (including this)
     */
    public static int listSize(ListNode head){
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            cur = cur.next;
            res++;
        }

        return res;
    }

    /**
     * Print this node and all the nodes linked to this node
     */
    public static String printList(ListNode head){
        ListNode cur = head;
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        while (cur != null) {
            sb.append(cur.val).append(", ");
            cur = cur.next;
        }
        if (head != null)
            sb.setLength(sb.length() - 2);
        sb.append("]");

        return sb.toString();
    }
}
