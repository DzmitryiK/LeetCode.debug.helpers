package com.dkhapps.tasks.LeetCodeDebugHelpers.kotlin.treenode


/**
 * TreeNodeHelper contains of helper functions
 * (package-level and extension to TreeNode class),
 * that can be used to create, analyze,
 * modify or compare TreeNode trees.
 */


/**
 * Creates a TreeNode tree out of vararg Int? [input].
 * Returns a root of a created tree.
 **/
fun treeNodeTreeOfInt(vararg input: Int?): TreeNode? {
    if (input.isEmpty() || input[0] == null)
        return null

    val root = TreeNode(input[0]!!)
    val queue = ArrayDeque<TreeNode>()
    queue.add(root)

    var i = 1
    var node: TreeNode
    while (!queue.isEmpty()) {
        node = queue.removeFirst()
        if (i < input.size && input[i] != null) {
            node.left = TreeNode(input[i]!!)
            queue.add(node.left!!)
        }
        i++
        if (i < input.size && input[i] != null) {
            node.right = TreeNode(input[i]!!)
            queue.add(node.right!!)
        }
        i++
    }

    return root
}

/**
 * Prints this node and all the nodes linked to this node
 */
fun TreeNode?.printTree(): String {
    if (this == null)
        return ""

    val sb = StringBuilder()
    // Length of those must be identical for readability
    val leftFiller = "|       "
    val rightFiller = "        "
    val leftPrefix = "|-(L)-> "
    val rightPrefix = "|-(R)-> "

    fun addLevel(curNode: TreeNode?, isLeft: Boolean, prefix: String) {
        if (curNode == null)
            return

        sb.append(prefix + (if (isLeft) leftPrefix else rightPrefix) + curNode.`val` + "\n")
        val newPrefix = prefix + (if (isLeft) leftFiller else rightFiller)
        addLevel(curNode.left, true, newPrefix)
        addLevel(curNode.right, false, newPrefix)
    }
    sb.append("${this.`val`} \n")
    addLevel(this.left, true, "")
    addLevel(this.right, false, "")

    return sb.toString()
}


/**
 *  Returns a number of nodes linked to this node (including this)
 */
fun TreeNode?.treeSize(): Int {
    if (this == null)
        return 0

    var res = 0
    val queue = ArrayDeque<TreeNode>()
    queue.add(this)
    var curRoot: TreeNode
    while (!queue.isEmpty()) {
        res++
        curRoot = queue.removeFirst()
        curRoot.left?.let { queue.add(it) }
        curRoot.right?.let { queue.add(it) }
    }

    return res
}


/**
 * Returns the first element of TreeNode tree starting with this TreeNode,
 * that matches the given [predicate].
 * If the item is not found - return null.
 *
 * Traversing the tree using Depth-First search, Preorder traversal.
 */
fun TreeNode?.firstDFS(predicate: (TreeNode) -> Boolean): TreeNode? {
    if (this == null)
        return null
    if (predicate(this)) {
        return this
    }
    var res: TreeNode? = null
    if (this.left != null)
        res = this.left.firstDFS(predicate)
    if (res == null && this.right != null)
        res = this.right.firstDFS(predicate)

    return res
}


/**
 * Creates a copy of given TreeNode tree.
 * Returns a root of a new tree.
 **/
fun TreeNode?.clone(): TreeNode? {
    if (this == null)
        return null

    fun dfs(curRoot: TreeNode): TreeNode {
        val newRoot = TreeNode(curRoot.`val`)
        newRoot.left = curRoot.left?.let { dfs(it) }
        newRoot.right = curRoot.right?.let { dfs(it) }

        return newRoot
    }

    return dfs(this)
}


/**
 * Compares [expected] and [actual] TreeNode trees by values,
 * starting from given TreeNode trees roots.
 * Returns true if trees are equal, false if not.
 **/
fun compareTreeNodeTrees(expected: TreeNode?, actual: TreeNode?): Boolean {
    val expectedQueue = ArrayDeque<TreeNode?>()
    expectedQueue.add(expected)
    val actualQueue = ArrayDeque<TreeNode?>()
    actualQueue.add(actual)
    while (expectedQueue.isNotEmpty() || actualQueue.isNotEmpty()) {
        val curExp = if (expectedQueue.isNotEmpty()) expectedQueue.removeFirst()
        else null
        val curAct = if (actualQueue.isNotEmpty()) actualQueue.removeFirst()
        else null

        if (curExp?.`val` != curAct?.`val`)
            return false

        if (curExp != null) {
            // curAct is always not null here
            expectedQueue.add(curExp.left)
            expectedQueue.add(curExp.right)
            actualQueue.add(curAct!!.left)
            actualQueue.add(curAct.right)
        }
    }

    return true
}

/**
 * Compares [expected] TreeNode tree with all of the [actuals] trees by values,
 * starting from given TreeNode roots.
 * Returns true if all [actuals] trees are equal to [expected],
 * false if at least one is not.
 **/
fun compareMultipleTreeNodeTrees(expected: TreeNode?, vararg actuals: TreeNode?): Boolean {
    for (c in actuals) {
        if (!compareTreeNodeTrees(expected, c))
            return false
    }
    return true
}