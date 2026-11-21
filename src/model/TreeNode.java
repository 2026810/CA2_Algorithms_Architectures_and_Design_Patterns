package model;

public class TreeNode {
    private StaffMember staff;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(StaffMember staff) {
        this.staff = staff;
        this.left = null;
        this.right = null;
    }

    public StaffMember getStaff() {
        return staff;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}