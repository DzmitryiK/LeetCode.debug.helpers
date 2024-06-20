package com.dkhapps.tasks.LeetCodeDebugHelpers.java.treenode;

/**
 * Pure implementation of TreeNode
 * straight from LeetCode,
 * with toString method added.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
