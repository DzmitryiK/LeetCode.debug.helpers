package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.listnode

/**
 * ListNodeHelper contains of helper functions
 * (package-level and extension to ListNode class),
 * that can be used to create, analyze,
 * modify or compare ListNode lists.
 */


/**
 * Creates a ListNode list out of vararg Int [input].
 * Returns a head ListNode of a created list or null.
 **/
fun listNodeListOfInt(vararg input: Int): ListNode? {
    if (input.isEmpty())
        return null

    val head = ListNode(input[0])
    var cur = head
    for (i in 1 until input.size) {
        cur.next = ListNode(input[i])
        cur = cur.next!!
    }

    return head
}

/**
 * Prints this node and all the nodes linked to this node.
 */
fun ListNode?.printList(): String {
    var cur: ListNode? = this
    val sb = StringBuilder()

    sb.append("[")
    while (cur != null) {
        sb.append("${cur.`val`}, ")
        cur = cur.next
    }
    if (this != null)
        sb.setLength(sb.length - 2)
    sb.append("]")

    return sb.toString()
}

/**
 * Gets ListNode list item by it's [index].
 * If the item is not found - return null.
 */
fun ListNode?.get(index: Int): ListNode? {
    var cur: ListNode? = this
    var i = 0
    while (cur != null) {
        if (i == index)
            return cur
        cur = cur.next
        i++
    }

    return null
}

/**
 *  Returns a number of nodes linked to this node (including this).
 */
fun ListNode?.listSize(): Int {
    var cur: ListNode? = this
    var res = 0
    while (cur != null) {
        cur = cur.next
        res++
    }

    return res
}

/**
 * Returns the first element of ListNode list starting with this ListNode,
 * that matches the given [predicate].
 * If the item is not found - return null.
 */
fun ListNode?.first(predicate: (ListNode) -> Boolean): ListNode? {
    var cur: ListNode? = this
    while (cur != null) {
        if (predicate(cur))
            return cur
        cur = cur.next
    }

    return null
}

/**
 * Creates a copy of given ListNode list.
 * Returns a head of a new list.
 **/
fun ListNode?.clone(): ListNode? {
    if (this == null)
        return null

    var cur: ListNode? = this
    val newFirst = ListNode(cur!!.`val`)
    var newCur = newFirst
    cur = cur.next
    while (cur != null) {
        newCur.next = ListNode(cur.`val`)
        newCur = newCur.next!!
        cur = cur.next
    }

    return newFirst
}

/**
 * Reverses a given ListNode list ([head]).
 *
 * Returns a head of a new reverted list, if [inPlace] = false (by default)
 * otherwise return a new head of given ListNode list (former tail).
 *
 * While using the latter beware of [head] parameter variable becomes tail of the list.
 **/
fun reverseList(head: ListNode?, inPlace: Boolean = false): ListNode? {
    if (head == null)
        return null

    var curr = if (inPlace) {
        head // Use original list
    } else {
        // Make a copy so that the original head remains intact
        head.clone()
    }
    var prev: ListNode? = null
    var next: ListNode?
    while (curr != null) {
        next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}

/**
 * Compares [expected] and [actual] ListNode lists by values,
 * starting from given ListNode lists heads.
 * Returns true if lists are equal, false if not.
 **/
fun compareListNodeLists(expected: ListNode?, actual: ListNode?): Boolean {
    if (expected?.`val` != actual?.`val`)
        return false

    var cur1 = expected
    var cur2 = actual
    while (cur1 != null || cur2 != null) {
        if (cur1?.`val` != cur2?.`val`)
            return false

        cur1 = cur1?.next
        cur2 = cur2?.next
    }

    return true
}

/**
 * Compares [expected] ListNode list with all of the [actuals] lists by values,
 * starting from given ListNode heads.
 * Returns true if all [actuals] lists are equal to [expected],
 * false if at least one is not.
 **/
fun compareMultipleListNodeLists(expected: ListNode?, vararg actuals: ListNode?): Boolean {
    for (c in actuals) {
        if (!compareListNodeLists(expected, c))
            return false
    }
    return true
}
