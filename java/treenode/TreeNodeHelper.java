package com.dkhapps.tasks.LeetCodeDebugHelpers.java.treenode;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * TreeNodeHelper contains of static helper functions,
 * that can be used to create, analyze,
 * modify or compare TreeNode trees.
 */
public class TreeNodeHelper {

    /**
     * Creates a TreeNode tree out of vararg Integer.
     *
     * @param input varargs Integer containing values of list to create.
     * @return A root TreeNode of a created tree or null
     **/
    public static TreeNode treeNodeTreeOfInt(Integer... input) {
        if (input.length == 0 || input[0] == null)
            return null;

        TreeNode root = new TreeNode(input[0]);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int i = 1;
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.removeFirst();
            if (i < input.length && input[i] != null) {
                node.left = new TreeNode(input[i]);
                queue.add(node.left);
            }
            i++;
            if (i < input.length && input[i] != null) {
                node.right = new TreeNode(input[i]);
                queue.add(node.right);
            }
            i++;
        }

        return root;
    }


    /**
     * Prints this node and all the nodes linked to this node
     *
     * @param root A root TreeNode of tree to print.
     * @return String implementation of given TreeNode tree.
     */
    public static String printTree(TreeNode root) {
        if (root == null)
            return "";

        StringBuilder sb = new StringBuilder();


        sb.append(root.val).append("\n");
        addLevelToPrint(root.left, true, "", sb);
        addLevelToPrint(root.right, false, "", sb);

        return sb.toString();
    }

    // Length of those must be identical for readability
    private static final String leftFiller = "|       ";
    private static final String rightFiller = "        ";
    private static final String leftPrefix = "|-(L)-> ";
    private static final String rightPrefix = "|-(R)-> ";

    private static void addLevelToPrint(TreeNode curNode, Boolean isLeft, String prefix, StringBuilder sb) {
        if (curNode == null)
            return;

        sb.append(prefix)
                .append(isLeft ? leftPrefix : rightPrefix)
                .append(curNode.val)
                .append("\n");
        String newPrefix = prefix + (isLeft ? leftFiller : rightFiller);
        addLevelToPrint(curNode.left, true, newPrefix, sb);
        addLevelToPrint(curNode.right, false, newPrefix, sb);
    }


    /**
     * Returns a number of nodes linked to this node (including root)
     *
     * @param root A root TreeNode of tree to count elements in.
     * @return The number of elements in this TreeNode tree.
     */
    public static int treeSize(TreeNode root) {
        if (root == null)
            return 0;

        int res = 0;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode curRoot;
        while (!queue.isEmpty()) {
            res++;
            curRoot = queue.removeFirst();
            if (curRoot.left != null)
                queue.add(curRoot.left);
            if (curRoot.right != null)
                queue.add(curRoot.right);
        }

        return res;
    }


    /**
     * Returns the first element of TreeNode tree starting with this TreeNode,
     * that matches the given predicate.
     * <p>
     * Traversing the tree using Depth-First search, Preorder traversal.
     *
     * @param root      A root TreeNode of tree to search element in.
     * @param predicate A predicate which returns true for matching element.
     * @return The first TreeNode element that matches the predicate or null.
     */
    public static TreeNode firstDFS(TreeNode root, Predicate<TreeNode> predicate) {
        if (root == null)
            return null;

        if (predicate.test(root)) {
            return root;
        }
        TreeNode res = null;
        if (root.left != null)
            res = firstDFS(root.left, predicate);
        if (res == null && root.right != null)
            res = firstDFS(root.right, predicate);
        return res;
    }


    /**
     * Creates a copy of given TreeNode tree.
     *
     * @param root A root TreeNode of tree to clone.
     * @return A root TreeNode of a new tree.
     **/
    public static TreeNode cloneTree(TreeNode root) {
        if (root == null)
            return null;

        return cloneTreeDfs(root);
    }

    private static TreeNode cloneTreeDfs(TreeNode curRoot) {
        TreeNode newRoot = new TreeNode(curRoot.val);
        if (curRoot.left != null)
            newRoot.left = cloneTreeDfs(curRoot.left);
        if (curRoot.right != null)
            newRoot.right = cloneTreeDfs(curRoot.right);

        return newRoot;
    }


    /**
     * Compares two TreeNode trees by values,
     * starting from given TreeNode roots.
     *
     * @param expected TreeNode tree root with whom to compare.
     * @param actual   TreeNode tree root which to compare.
     * @return True if trees are equal, false if not.
     **/
    public static boolean compareTreeNodeTrees(TreeNode expected, TreeNode actual) {
        if (expected == null && actual == null)
            return true;

        ArrayDeque<Optional<TreeNode>> expectedQueue = new ArrayDeque<>();
        expectedQueue.add(expected != null ? Optional.of(expected) : Optional.empty());
        ArrayDeque<Optional<TreeNode>> actualQueue = new ArrayDeque<>();
        actualQueue.add(actual != null ? Optional.of(actual) : Optional.empty());
        while (!expectedQueue.isEmpty() || !actualQueue.isEmpty()) {
            Optional<TreeNode> curExp = !expectedQueue.isEmpty() ? expectedQueue.removeFirst() : Optional.empty();
            Optional<TreeNode> curAct = !actualQueue.isEmpty() ? actualQueue.removeFirst() : Optional.empty();

            if ((curExp.isPresent() && curAct.isPresent() && curExp.get().val != curAct.get().val) ||
                    (curExp.isPresent() ^ curAct.isPresent())) { // if only one of two is null
                return false;
            }

            if (curExp.isPresent()) {
                // curAct.isPresent() is always true here
                expectedQueue.add(
                        curExp.get().left != null ?
                                Optional.of(curExp.get().left) :
                                Optional.empty()
                );
                expectedQueue.add(
                        curExp.get().right != null ?
                                Optional.of(curExp.get().right) :
                                Optional.empty()
                );

                actualQueue.add(
                        curAct.get().left != null ?
                                Optional.of(curAct.get().left) :
                                Optional.empty()
                );
                actualQueue.add(
                        curAct.get().right != null ?
                                Optional.of(curAct.get().right) :
                                Optional.empty()
                );
            }
        }

        return true;
    }

    /**
     * Compares multiple TreeNode trees by values,
     * starting from given TreeNode roots.
     *
     * @param expected TreeNode tree root with whom to compare.
     * @param actuals  TreeNode trees roots which to compare.
     * @return True if all actuals trees are equal to expected, false if not.
     **/
    public static boolean compareMultipleTreeNodeTrees(TreeNode expected, TreeNode... actuals) {
        for (TreeNode c : actuals) {
            if (!compareTreeNodeTrees(expected, c))
                return false;
        }
        return true;
    }
}
