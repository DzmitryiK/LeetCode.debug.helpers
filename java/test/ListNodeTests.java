package com.dkhapps.tasks.LeetCodeDebugHelpers.java.test;


import static com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode.ListNodeHelper.*;
import static com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode.ListNodeAssertHelper.*;

import com.dkhapps.tasks.LeetCodeDebugHelpers.java.listnode.ListNode;

import org.junit.Test;

public class ListNodeTests {

    @Test
    public void listNodeMainJavaTest() {
        ListNode firstList = listNodeListOfInt(1, 2, 3, 4);
        System.out.println(firstList.toString()); // prints 1

        System.out.println(printList(firstList)); // prints [1,2,3,4]

        System.out.println(getListNode(firstList, 1)); // prints 2

        System.out.println(listSize(firstList)); // prints 4

        System.out.println(firstListNode(firstList, it -> it.val % 3 == 0)); // prints 3

        ListNode firstListCopy = cloneList(firstList);
        System.out.println(printList(firstListCopy)); // prints [1,2,3,4]

        ListNode firstListCopyRev = reverseList(firstListCopy);
        System.out.println(printList(firstListCopyRev)); // prints [4,3,2,1]

        System.out.println(compareListNodeLists(firstList, firstListCopy)); // prints true
        System.out.println(
                compareMultipleListNodeLists(
                        firstList,
                        firstListCopy,
                        firstListCopyRev
                )
        ); //prints false

        ListNode firstListCopyRev2 = reverseList(firstListCopy, true);
        System.out.println(printList(firstListCopy)); // prints [1]
        System.out.println(printList(firstListCopyRev2)); // prints [4,3,2,1]

        assertListNodeListEquals(firstListCopyRev, firstListCopyRev2); // passes

        assertListNodeListEquals(
                "ListNode list error",
                firstListCopyRev, firstListCopy
        ); // fails with message

    }
}
