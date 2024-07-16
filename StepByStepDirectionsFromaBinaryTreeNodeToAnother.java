import javax.swing.tree.TreeModel;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}

public class StepByStepDirectionsFromaBinaryTreeNodetoAnother {

    private TreeNode lca(TreeNode root, int start, int end) {
        if (root == null) return null;
        if (root.val == start || root.val == end) return root;

        TreeNode left = lca(root.left, start, end);
        TreeNode right = lca(root.right, start, end);

        if (left != null && right != null) return root;
        return left != null ? left : right;
    }

    private boolean up(TreeNode root, int start, StringBuffer sb) {
        if (root == null) return false;
        if (root.val == start) return true;

        boolean res = up(root.left, start, sb) || up(root.right, start, sb);
        if (res) sb.append("U");
        return res;
    }

    private boolean lrd(int des, TreeNode root, StringBuffer sb) {
        if (root == null) return false;
        if (root.val == des) return true;

        if (lrd(des, root.left, sb)) {
            sb.append("L");
            return true;
        }
        if (lrd(des, root.right, sb)) {
            sb.append("R");
            return true;
        }
        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = lca(root, startValue, destValue);
        StringBuffer sb = new StringBuffer();
        up(lca, startValue, sb);
        StringBuffer sb2 = new StringBuffer();
        lrd(destValue, lca, sb2);
        return sb.toString() + sb2.reverse().toString();
    }

    public static void main(String[] args) {
        StepByStepDirectionsFromaBinaryTreeNodetoAnother t = new StepByStepDirectionsFromaBinaryTreeNodetoAnother();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(t.getDirections(root, 4, 7));
    }
}
