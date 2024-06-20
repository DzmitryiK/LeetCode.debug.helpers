package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.listnode

/**
 * Pure implementation of ListNode
 * straight from LeetCode,
 * with toString method added.
 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}
