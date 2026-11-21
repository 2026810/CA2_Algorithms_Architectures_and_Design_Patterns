package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SchoolBinaryTree {
    private TreeNode root;

    public SchoolBinaryTree() {
        this.root = null;
    }

    // Level-Order (Breadth-First) Insertion
    public void insertLevelOrder(StaffMember staff) {
        TreeNode newNode = new TreeNode(staff);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }

    // Level-Order Traversal
    public List<String> getLevelOrderHierarchy() {
        List<String> hierarchyOutput = new ArrayList<>();
        if (root == null) {
            return hierarchyOutput;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();
            hierarchyOutput.add("--- Level " + level + " ---");

            for (int i = 0; i < nodesAtCurrentLevel; i++) {
                TreeNode current = queue.poll();
                hierarchyOutput.add("  " + current.getStaff().toString());

                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                }
            }
            level++;
        }
        return hierarchyOutput;
    }

   
    public int getHeight() {
        return calculateHeight(root);
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.getLeft());
        int rightHeight = calculateHeight(node.getRight());
        return 1 + Math.max(leftHeight, rightHeight);
    }

    
    public int getTotalNodeCount() {
        return countNodes(root);
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.getLeft()) + countNodes(node.getRight());
    }
}