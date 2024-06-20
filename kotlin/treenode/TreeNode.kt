package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.treenode


/**
 * Pure implementation of TreeNode
 * straight from LeetCode,
 * with toString method added.
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return `val`.toString()
    }
}