package com.dkhapps.tasks.leetcode.kotlin.debug

/**
 * Creates a LinkedList out of vararg Int
 **/
fun listNodeListOfInt(vararg input:Int): ListNode? {
    var cur: ListNode? = ListNode(0)
    val prev = cur!!
    for (num in input) {
        cur!!.next = ListNode(num)
        cur = cur.next
    }

    return prev.next
}

/**
 * Reverses a given LinkedList
 **/
fun reverseList(head: ListNode?): ListNode? {
    if (head == null)
        return null

    var curr = head
    var prev: ListNode? = null
    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}

/**
 * Compares two LinkedLists by values, starting from given ListNode heads.
 * Returns true if lists are equal, false if not.
**/
fun compareListNodeLists(expected: ListNode?, actual: ListNode?): Boolean{
    if (expected?.`val` != actual?.`val`)
        return false

    var cur1 = expected
    var cur2 = actual
    while (cur1 != null || cur2 != null){
        if (cur1?.`val` != cur2?.`val`)
            return false

        cur1 = cur1?.next
        cur2 = cur2?.next
    }

    return true
}

/**
  * Compares expected LinkedList with all of the actuals lists by values, starting from given ListNode heads.
  * Returns true if all actuals lists are equal to expected, false if at least one is not.
 **/
fun compareMultipleListNodeLists(expected: ListNode?, vararg actuals: ListNode?): Boolean{
    for (c in actuals){
        if (!compareListNodeLists(expected, c))
            return false
    }
    return true
}
