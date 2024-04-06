package com.dkhapps.tasks.leetcode.java.debug;

public class ListNodeHelper {

    /**
     * Creates a LinkedList out of varargs Int
     **/
    public static ListNode listNodeListOfInt(int... input) {
        ListNode cur = new ListNode(0);
        ListNode prev = cur;
        for (int num : input) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        return prev.next;
    }

    /**
     * Reverses a given LinkedList
     **/
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * Compares two LinkedLists by values, starting from given ListNode heads.
     * Returns true if lists are equal, false if not.
     **/
    public static Boolean compareListNodeLists(ListNode expected, ListNode actual) {
        if (expected.val != actual.val)
            return false;

        ListNode cur1 = expected;
        ListNode cur2 = actual;
        while (cur1 != null || cur2 != null){
            if (cur1 == null || cur2 == null || cur1.val != cur2.val)
                return false;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return true;
    }

    /**
     * Compares expected LinkedList with all of the actuals lists by values, starting from given ListNode heads.
     * Returns true if all actuals lists are equal to expected, false if at least one is not.
     **/
    public static Boolean compareMultipleListNodeLists(ListNode expected, ListNode... actuals) {
        for (ListNode c : actuals){
            if (!compareListNodeLists(expected, c))
                return false;
        }
        return true;
    }
}
