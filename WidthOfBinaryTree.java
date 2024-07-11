///**
// * Definition for a binary tree node.
// * public class TreeNode {
// *     int val;
// *     TreeNode left;
// *     TreeNode right;
// *     TreeNode() {}
// *     TreeNode(int val) { this.val = val; }
// *     TreeNode(int val, TreeNode left, TreeNode right) {
// *         this.val = val;
// *         this.left = left;
// *         this.right = right;
// *     }
// * }
// */
//class WidthOfBinaryTree {
//    public int getWidth(TreeNode root, int level, int nodeNum, ArrayList<Integer> temp) {
//        if (root == null) return 0;
//        if (level == temp.size()) temp.add(nodeNum);
//        int curr = nodeNum-temp.get(level)+1;
//        int first = temp.get(level);
//        int leftW = getWidth(root.left, level+1, 2*(nodeNum-first)+1, temp);
//        int rightW = getWidth(root.right, level+1, 2*(nodeNum-first)+2, temp);
//        return Math.max(curr, Math.max(leftW, rightW));
//    }
//
//    public int widthOfBinaryTree(TreeNode root) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        return getWidth(root, 0, 0, temp);
//    }
//}