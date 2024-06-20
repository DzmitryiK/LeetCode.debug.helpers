package com.dkhapps.tasks.LeetCodeDebugHelpers.java.test;

import static com.dkhapps.tasks.LeetCodeDebugHelpers.java.treenode.TreeNodeHelper.*;
import static com.dkhapps.tasks.LeetCodeDebugHelpers.java.treenode.TreeNodeAssertHelper.*;

import com.dkhapps.tasks.LeetCodeDebugHelpers.java.treenode.TreeNode;

import org.junit.Test;

public class TreeNodeTests {

    @Test
    public void treeNodeMainJavaTest() {
        TreeNode firstTree = treeNodeTreeOfInt(1, 2, 3, 4);
        System.out.println(firstTree.toString()); // prints 1
        System.out.println();

        System.out.println(printTree(firstTree)); // prints 3-level tree

        System.out.println(treeSize(firstTree)); // prints 4

        System.out.println(firstDFS(firstTree, it -> it.val % 3 == 0)); // prints 3
        System.out.println();

        TreeNode firstTreeCopy = cloneTree(firstTree);
        System.out.println(printTree(firstTreeCopy)); // prints tree

        System.out.println(compareTreeNodeTrees(firstTree, firstTreeCopy)); // prints true

        TreeNode firstTreeCopy2 = cloneTree(firstTree);
        firstTreeCopy2.val = 5;
        System.out.println(printTree(firstTreeCopy2)); // prints tree
        System.out.println(
                compareMultipleTreeNodeTrees(
                        firstTree,
                        firstTreeCopy,
                        firstTreeCopy2
                )
        ); // prints false

        // complicated sources with nulls
        System.out.println(printTree(treeNodeTreeOfInt(1, null, 1)));
        System.out.println(
                printTree(
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
                        ))
        );

        assertTreeNodeTreeEquals(firstTree, firstTreeCopy); // passes

        assertTreeNodeTreeEquals(
                "Tree error",
                firstTree, firstTreeCopy2
        ); // fails with message
    }
}
