package com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode;

import java.util.function.Predicate;

/**
 * ListNodeHelper contains of static helper functions,
 * that can be used to create, analyze,
 * modify or compare ListNode lists.
 */
public class ListNodeHelper {

    /**
     * Creates a ListNode list out of vararg Int
     * @param input varargs int containing values of list to create.
     * @return A head ListNode of a created list or null
     **/
    public static ListNode listNodeListOfInt(int... input) {
        if (input.length == 0)
            return null;

        ListNode cur = new ListNode(0);
        ListNode prev = cur;
        for (int num : input) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }

        return prev.next;
    }

    /**
     * Prints this node and all the nodes linked to this node.
     * @param head A head ListNode of list to print.
     * @return String implementation of given ListNode list.
     */
    public static String printList(ListNode head) {
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

    /**
     * Gets ListNode list item by it's index.
     * @param head A head ListNode of list to search (0th element).
     * @param index Index of an item to find (0-based).
     * @return Found item or null.
     */
    public static ListNode getListNode(ListNode head, int index){
        ListNode cur = head;
        int i = 0;
        while (cur != null) {
            if (i == index)
                return cur;
            cur = cur.next;
            i++;
        }

        return null;
    }

    /**
     * Return a number of nodes linked to this node (including this)
     * @param head A head ListNode of list to count elements in.
     * @return The number of elements in this ListNode list.
     */
    public static int listSize(ListNode head) {
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            cur = cur.next;
            res++;
        }

        return res;
    }

    /**
     * Returns the first element of ListNode list starting with this ListNode,
     * that matches the given predicate.
     * @param head A head ListNode of list to search element in.
     * @param predicate A predicate which returns true for matching element.
     * @return The first ListNode element that matches the predicate or null.
     */
    public static ListNode firstListNode(ListNode head, Predicate<ListNode> predicate) {
        ListNode cur = head;
        while (cur != null) {
            if (predicate.test(cur))
                return cur;
            cur = cur.next;
        }

        return null;
    }

    /**
     * Creates a copy of given ListNode list.
     * @param head A head ListNode of list to clone.
     * @return A head ListNode of a new list.
     **/
    public static ListNode cloneList(ListNode head) {
        if (head == null)
            return null;

        ListNode cur = head;
        ListNode newFirst = new ListNode(cur.val);
        ListNode newCur = newFirst;
        cur = cur.next;
        while (cur != null) {
            newCur.next = new ListNode(cur.val);
            newCur = newCur.next;
            cur = cur.next;
        }

        return newFirst;
    }

    /**
     * Reverses a given ListNode list.
     * @param head A head ListNode of list to reverse.
     * @param inPlace If false (by default) the method will return a head of a new reverted list,
     * otherwise it will return a new head of given ListNode list (former tail).
     * While using the latter beware of head parameter variable becomes tail of the list.
     * @return A head ListNode of a reverted list.
     **/
    public static ListNode reverseList(ListNode head, Boolean inPlace) {
        if (head == null)
            return null;

        ListNode curr = inPlace ?
            head // Use original list
        :
            // Make a copy so that the original head remains intact
            cloneList(head);

        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    /**
     * One parameter version of {@link #reverseList(ListNode, Boolean) reverseList},
     * that creates a new ListNode list and then reverses it.
     * @param head A head ListNode of list to reverse.
     * @return A head ListNode of a new reverted list.
     **/
    public static ListNode reverseList(ListNode head) {
        return reverseList(head, false);
    }

    /**
     * Compares two ListNode lists by values,
     * starting from given ListNode heads.
     * @param expected ListNode list head with whom to compare.
     * @param actual ListNode list head which to compare.
     * @return True if lists are equal, false if not.
     **/
    public static boolean compareListNodeLists(ListNode expected, ListNode actual) {
        if (expected.val != actual.val)
            return false;

        ListNode cur1 = expected;
        ListNode cur2 = actual;
        while (cur1 != null || cur2 != null){
            if (cur1 == null || cur2 == null ||
                    cur1.val != cur2.val)
                return false;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        return true;
    }

    /**
     * Compares multiple ListNode lists by values,
     * starting from given ListNode heads.
     * @param expected ListNode list head with whom to compare.
     * @param actuals ListNode lists heads which to compare.
     * @return True if all actuals lists are equal to expected, false if not.
     **/
    public static boolean compareMultipleListNodeLists(ListNode expected, ListNode... actuals) {
        for (ListNode c : actuals){
            if (!compareListNodeLists(expected, c))
                return false;
        }
        return true;
    }
}
