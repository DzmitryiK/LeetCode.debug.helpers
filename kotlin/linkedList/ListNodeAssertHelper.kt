package com.dkhapps.tasks.leetcode.kotlin.debug

import org.junit.Assert

/**
 * Asserts that two LinkedLists are equals by values. If they are not, an
 * AssertionError is thrown without the message.
 */
fun assertListNodeListEquals(expected: ListNode?, actual: ListNode?) {
    assertListNodeListEquals(null, expected, actual)
}

/**
 * Asserts that two LinkedLists are equals by values. If they are not, an
 * AssertionError is thrown with the given message.
 */
fun assertListNodeListEquals(message: String?, expected: ListNode?, actual: ListNode?) {
    val header = if (message == null) "" else "$message: \n"

    if (expected == null) {
        Assert.fail(header + "expected LinkedList was null")
    }
    if (actual == null) {
        Assert.fail(header + "actual LinkedList was null")
    }

    var curExpected = expected
    var curActual = actual
    var leastSize = 0
    while (curExpected != null || curActual != null){
        if (curExpected == null)
            Assert.fail(header + "expected LinkedList size = $leastSize, actual LinkedList is longer")

        if (curActual == null)
            Assert.fail(header + "actual LinkedList size = $leastSize, expected LinkedList is longer")

        if (curExpected?.`val` != curActual?.`val`) {
            Assert.fail(header + "expected: ${expected.printList()} \nbut was:  ${actual.printList()} ")
        }

        curExpected = curExpected?.next
        curActual = curActual?.next
        leastSize++
    }
}