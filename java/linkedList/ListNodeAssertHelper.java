package com.dkhapps.tasks.leetcode.java.debug;

import static com.dkhapps.tasks.leetcode.java.debug.ListNode.printList;

import org.junit.Assert;

public class ListNodeAssertHelper {
    /**
     * Asserts that two LinkedLists are equals by values. If they are not, an
     * AssertionError is thrown without the message.
     */
    public static void assertListNodeListEquals(ListNode expected, ListNode actual) {
        assertListNodeListEquals(null, expected, actual);
    }

    /**
     * Asserts that two LinkedLists are equals by values. If they are not, an
     * AssertionError is thrown with the given message.
     */
    public static void assertListNodeListEquals(String message, ListNode expected, ListNode actual){
        String header = "";
        if (message != null)
            header = message+": \n";

        if (expected == null) {
            Assert.fail(header + "expected LinkedList was null");
        }
        if (actual == null) {
            Assert.fail(header + "actual LinkedList was null");
        }

        ListNode curExpected = expected;
        ListNode curActual = actual;
        int leastSize = 0;
        while (curExpected != null || curActual != null){
            if (curExpected == null)
                Assert.fail(header + "expected LinkedList size = "+leastSize+", actual LinkedList is longer");

            if (curActual == null)
                Assert.fail(header + "actual LinkedList size = "+leastSize+", expected LinkedList is longer");

            if (curExpected.val != curActual.val) {
                Assert.fail(header + "expected: "+ printList(expected)+" \nbut was:  "+printList(actual)+" ");
            }

            curExpected = curExpected.next;
            curActual = curActual.next;
            leastSize++;
        }
    }
}
