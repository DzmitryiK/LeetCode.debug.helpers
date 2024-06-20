package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.listnode

import org.junit.Assert

/**
 * ListNodeAssertHelper contains of assertion functions,
 * that can be used to test equality of two ListNode lists,
 * using JUnit.
 */


/**
 * Asserts that [expected] and [actual] ListNode lists are equals by values.
 * If they are not, an AssertionError is thrown without the message.
 */
fun assertListNodeListEquals(expected: ListNode?, actual: ListNode?) {
    assertListNodeListEquals(null, expected, actual)
}

/**
 * Asserts that [expected] and [actual] ListNode lists are equals by values.
 * If they are not, an AssertionError is thrown with the given [message].
 */
fun assertListNodeListEquals(message: String?, expected: ListNode?, actual: ListNode?) {
    val header = if (message == null) "" else "$message: \n"

    if (expected == null) {
        Assert.fail(header + "expected ListNode list was null")
    }
    if (actual == null) {
        Assert.fail(header + "actual ListNode list was null")
    }

    var curExpected = expected
    var curActual = actual
    var listSize = 0
    while (curExpected != null || curActual != null) {
        if (curExpected == null)
            Assert.fail(header + "expected ListNode list size = $listSize, actual ListNode list is longer")

        if (curActual == null)
            Assert.fail(header + "actual ListNode list size = $listSize, expected ListNode list is longer")

        if (curExpected?.`val` != curActual?.`val`) {
            Assert.fail(header + "expected: ${expected.printList()} \nbut was:  ${actual.printList()} ")
        }

        curExpected = curExpected?.next
        curActual = curActual?.next
        listSize++
    }
}