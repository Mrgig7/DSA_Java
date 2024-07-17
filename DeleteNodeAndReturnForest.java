import java.util.*;

public class DeleteNodeAndReturnForest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> li = new ArrayList<>();
        if (root == null) return li;
        
        HashSet<Integer> tds = new HashSet<>();
        for (int i : to_delete) tds.add(i);
        
        root = deleteNodes(root, tds, li);
        if (root != null) li.add(root);
        
        return li;
    }

    private TreeNode deleteNodes(TreeNode root, HashSet<Integer> tds, List<TreeNode> li) {
        if (root != null) {
            root.left = deleteNodes(root.left, tds, li);
            root.right = deleteNodes(root.right, tds, li);
            
            if (tds.contains(root.val)) {
                if (root.left != null) li.add(root.left);
                if (root.right != null) li.add(root.right);
                return null;
            }
            
            return root;
        }
        return null;
    }

    public static void main(String[] args) {
        DeleteNodeAndReturnForest dnrf = new DeleteNodeAndReturnForest();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int[] to_delete = {3, 5};
        List<TreeNode> result = dnrf.delNodes(root, to_delete);
        for (TreeNode node : result) {
            System.out.println(node.val);
        }
    }
}
