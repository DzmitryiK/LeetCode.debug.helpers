package com.dkhapps.tasks.leetcode.kotlin.debug


class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}

/**
 *  Return a number of nodes linked to this node (including this)
 */
fun ListNode?.listSize(): Int{
    var cur: ListNode? = this
    var res = 0
    while (cur != null) {
        cur = cur.next
        res++
    }

    return res
}

/**
 * Print this node and all the nodes linked to this node
 */
fun ListNode?.printList(): String{
    var cur:ListNode? = this
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