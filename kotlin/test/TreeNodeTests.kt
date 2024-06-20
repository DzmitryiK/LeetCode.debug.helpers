package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.test

import com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.treenode.*
import org.junit.Test

class TreeNodeTests {

    @Test
    fun treeNodeMainKotlinTest() {
        val firstTree = treeNodeTreeOfInt(1, 2, 3, 4)
        println(firstTree.toString()) // prints 1
        println("")

        println(firstTree.printTree()) // prints 3-level tree

        println(firstTree.treeSize()) // prints 4

        println(firstTree.firstDFS { it.`val` % 3 == 0 }) // prints 3
        println("")

        val firstTreeCopy = firstTree.clone()
        println(firstTreeCopy.printTree()) // prints tree

        println(compareTreeNodeTrees(firstTree, firstTreeCopy)) // prints true

        val firstTreeCopy2 = firstTree.clone()!!
        firstTreeCopy2.`val` = 5
        println(firstTreeCopy2.printTree()) // prints tree
        println(
            compareMultipleTreeNodeTrees(
                firstTree,
                firstTreeCopy,
                firstTreeCopy2
            )
        ) // prints false

        // complicated sources with nulls
        println(treeNodeTreeOfInt(1, null, 1).printTree())
        println(
            treeNodeTreeOfInt(
                1,
                null,
                1,
                1,
                1,
                null,
                null,
                1,
                1,
                null,
                1,
                null,
                null,
                null,
                1
            ).printTree()
        )

        assertTreeNodeTreeEquals(firstTree, firstTreeCopy) // passes

        assertTreeNodeTreeEquals(
            "Tree error",
            firstTree, firstTreeCopy2
        ) // fails with message
    }
}