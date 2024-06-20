package com.dkhapps.tasks.LeetCodeDebugHelpers.java.treenode;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Optional;

/**
 * TreeNodeAssertHelper contains of assertion functions,
 * that can be used to test equality of two TreeNode trees,
 * using JUnit.
 */
public class TreeNodeAssertHelper {

    /**
     * Asserts that two TreeNode trees are equals by values.
     * If they are not, an AssertionError is thrown without the message.
     *
     * @param expected TreeNode tree root with whom to compare.
     * @param actual   TreeNode tree root which to compare.
     */
    public static void assertTreeNodeTreeEquals(TreeNode expected, TreeNode actual) {
        assertTreeNodeTreeEquals(null, expected, actual);
    }

    /**
     * Asserts that two TreeNode trees are equals by values.
     * If they are not, an AssertionError is thrown without the message.
     *
     * @param expected TreeNode tree root with whom to compare.
     * @param actual   TreeNode tree root which to compare.
     * @param message  String message to append to AssertionError.
     */
    public static void assertTreeNodeTreeEquals(String message, TreeNode expected, TreeNode actual) {
        String header = message == null ? "" : message + ": \n";

        if (expected == null) {
            Assert.fail(header + "expected TreeNode tree was null");
        }
        if (actual == null) {
            Assert.fail(header + "actual TreeNode tree was null");
        }

        ArrayDeque<Optional<TreeNode>> expectedQueue = new ArrayDeque<>();
        expectedQueue.add(Optional.of(expected));
        ArrayDeque<Integer> expectedLevelsQueue = new ArrayDeque<>();
        expectedLevelsQueue.add(0);
        ArrayDeque<Optional<TreeNode>> actualQueue = new ArrayDeque<>();
        actualQueue.add(Optional.of(actual));
        ArrayDeque<Integer> actualLevelsQueue = new ArrayDeque<>();
        actualLevelsQueue.add(0);
        int curLevel = 0;
        int curLevelId = -1;
        while (!expectedQueue.isEmpty() || !actualQueue.isEmpty()) {
            Optional<TreeNode> curExp = !expectedQueue.isEmpty() ? expectedQueue.removeFirst() : Optional.empty();
            Optional<TreeNode> curAct = !actualQueue.isEmpty() ? actualQueue.removeFirst() : Optional.empty();
            Integer expLevel = !expectedLevelsQueue.isEmpty() ? expectedLevelsQueue.removeFirst() : null;
            Integer actlevel = !actualLevelsQueue.isEmpty() ? actualLevelsQueue.removeFirst() : null;

            int level = expLevel != null ? expLevel : (actlevel != null ? actlevel : -1);
            if (curLevel < level) {
                curLevel++;
                curLevelId = 0;
            } else
                curLevelId++;

            if ((curExp.isPresent() && curAct.isPresent() && curExp.get().val != curAct.get().val) ||
                    (curExp.isPresent() ^ curAct.isPresent())) { // if only one of two is null
                Assert.fail(
                        header + "level " + level +
                                ", node " + curLevelId + " - expected [" +
                                curExp.orElse(null) + "] but was: [" +
                                curAct.orElse(null) + "]"
                );
            }

            if (curExp.isPresent()) {
                // curAct.isPresent() is always true here
                expectedQueue.add(
                        curExp.get().left != null ?
                                Optional.of(curExp.get().left) :
                                Optional.empty()
                );
                expectedLevelsQueue.add(level + 1);
                expectedQueue.add(
                        curExp.get().right != null ?
                                Optional.of(curExp.get().right) :
                                Optional.empty()
                );
                expectedLevelsQueue.add(level + 1);

                actualQueue.add(
                        curAct.get().left != null ?
                                Optional.of(curAct.get().left) :
                                Optional.empty()
                );
                actualLevelsQueue.add(level + 1);
                actualQueue.add(
                        curAct.get().right != null ?
                                Optional.of(curAct.get().right) :
                                Optional.empty()
                );
                actualLevelsQueue.add(level + 1);
            }
        }
    }
}
