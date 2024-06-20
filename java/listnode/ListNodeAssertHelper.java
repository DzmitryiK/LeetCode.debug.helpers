package com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode;


import static com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode.ListNodeHelper.printList;

import org.junit.Assert;

/**
 * ListNodeAssertHelper contains of assertion functions,
 * that can be used to test equality of two ListNode lists,
 * using JUnit.
 */
public class ListNodeAssertHelper {
    /**
     * Asserts that two ListNode lists are equals by values.
     * If they are not, an AssertionError is thrown without the message.
     * @param expected ListNode list head with whom to compare.
     * @param actual ListNode list head which to compare.
     */
    public static void assertListNodeListEquals(ListNode expected, ListNode actual) {
        assertListNodeListEquals(null, expected, actual);
    }

    /**
     * Asserts that two ListNode lists are equals by values.
     * If they are not, an AssertionError is thrown with the given message.
     * @param expected ListNode list head with whom to compare.
     * @param actual ListNode list head which to compare.
     * @param message String message to append to AssertionError.
     */
    public static void assertListNodeListEquals(String message, ListNode expected, ListNode actual){
        String header = "";
        if (message != null)
            header = message+": \n";

        if (expected == null) {
            Assert.fail(header + "expected ListNode list was null");
        }
        if (actual == null) {
            Assert.fail(header + "actual ListNode list was null");
        }

        ListNode curExpected = expected;
        ListNode curActual = actual;
        int listSize = 0;
        while (curExpected != null || curActual != null){
            if (curExpected == null)
                Assert.fail(header + "expected ListNode list size = "+listSize+", actual ListNode list is longer");

            if (curActual == null)
                Assert.fail(header + "actual ListNode list size = "+listSize+", expected ListNode list is longer");

            if (curExpected.val != curActual.val) {
                Assert.fail(header + "expected: "+ printList(expected)+" \nbut was:  "+printList(actual)+" ");
            }

            curExpected = curExpected.next;
            curActual = curActual.next;
            listSize++;
        }
    }
}
