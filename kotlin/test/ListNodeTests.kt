package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.test

import com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.listnode.*
import org.junit.Test

class ListNodeTests {

    @Test
    fun listNodeMainKotlinTest() {
        val firstList = listNodeListOfInt(1, 2, 3, 4)
        println(firstList.toString()) // prints 1

        println(firstList.printList()) // prints [1,2,3,4]

        println(firstList.get(1)) // prints 2

        println(firstList.listSize()) // prints 4

        println(firstList.first { it.`val` % 3 == 0 }) // prints 3

        val firstListCopy = firstList.clone()
        println(firstListCopy.printList()) // prints [1,2,3,4]

        val firstListCopyRev = reverseList(firstListCopy)
        println(firstListCopyRev.printList()) // prints [4,3,2,1]

        println(compareListNodeLists(firstList, firstListCopy)) // prints true
        println(
            compareMultipleListNodeLists(
                firstList,
                firstListCopy,
                firstListCopyRev
            )
        ) //prints false

        val firstListCopyRev2 = reverseList(firstListCopy, true)
        println(firstListCopy.printList()) // prints [1]
        println(firstListCopyRev2.printList()) // prints [4,3,2,1]

        assertListNodeListEquals(firstListCopyRev, firstListCopyRev2) // passes

        assertListNodeListEquals(
            "ListNode list error",
            firstListCopyRev, firstListCopy
        ) // fails with message
    }
}