package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.treenode


import org.junit.Assert

/**
 * TreeNodeAssertHelper contains of assertion functions,
 * that can be used to test equality of two TreeNode trees,
 * using JUnit.
 */


/**
 * Asserts that [expected] and [actual] TreeNode trees are equals by values.
 * If they are not, an AssertionError is thrown without the message.
 */
fun assertTreeNodeTreeEquals(expected: TreeNode?, actual: TreeNode?) {
    assertTreeNodeTreeEquals(null, expected, actual)
}

/**
 * Asserts that [expected] and [actual] TreeNode trees are equals by values.
 * If they are not, an AssertionError is thrown with the given [message].
 */
fun assertTreeNodeTreeEquals(message: String?, expected: TreeNode?, actual: TreeNode?) {
    val header = if (message == null) "" else "$message: \n"

    if (expected == null) {
        Assert.fail(header + "expected TreeNode tree was null")
    }
    if (actual == null) {
        Assert.fail(header + "actual TreeNode tree was null")
    }

    val expectedQueue = ArrayDeque<Pair<TreeNode, Int>?>()
    expectedQueue.add(Pair(expected!!, 0))
    val actualQueue = ArrayDeque<Pair<TreeNode, Int>?>()
    actualQueue.add(Pair(actual!!, 0))
    var curLevel = 0
    var curLevelId = -1
    while (expectedQueue.isNotEmpty() || actualQueue.isNotEmpty()) {
        val curExp = if (expectedQueue.isNotEmpty()) expectedQueue.removeFirst()
        else null
        val curAct = if (actualQueue.isNotEmpty()) actualQueue.removeFirst()
        else null

        val level = curExp?.second ?: curAct?.second ?: -1
        if (curLevel < level) {
            curLevel++
            curLevelId = 0
        } else
            curLevelId++
        if (curExp?.first?.`val` != curAct?.first?.`val`) {
            Assert.fail(
                header + "level $level, node $curLevelId - expected [${curExp?.first?.`val`}] " +
                        "but was: [${curAct?.first?.`val`}]"
            )
        }


        if (curExp != null && curAct != null) {
            if (curExp.first.left != null)
                expectedQueue.add(Pair(curExp.first.left!!, level + 1))
            else
                expectedQueue.add(null)
            if (curExp.first.right != null)
                expectedQueue.add(Pair(curExp.first.right!!, level + 1))
            else
                expectedQueue.add(null)
            if (curAct.first.left != null)
                actualQueue.add(Pair(curAct.first.left!!, level + 1))
            else
                actualQueue.add(null)
            if (curAct.first.right != null)
                actualQueue.add(Pair(curAct.first.right!!, level + 1))
            else
                actualQueue.add(null)
        }
    }
}