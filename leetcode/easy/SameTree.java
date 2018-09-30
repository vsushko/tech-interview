package easy;

/**
 * 100. Same Tree
 *
 * @author vsushko
 */
public class SameTree {

    public static void main(String[] args) {
        TreeNode t13 = new TreeNode(1);
        TreeNode t12 = new TreeNode(2);
        TreeNode t11 = new TreeNode(3);
        t11.left = t12;
        t11.right = t13;

        TreeNode t23 = new TreeNode(1);
        TreeNode t22 = new TreeNode(2);
        TreeNode t21 = new TreeNode(3);
        t21.left = t22;
        t21.right = t23;
        System.out.println(isSameTree(t11, t21));

        t11.right = null;
        t21.left = null;
        System.out.println(isSameTree(t11, t21));

        t11.right = new TreeNode(1);
        t21.left = new TreeNode(1);
        System.out.println(isSameTree(t11, t21));
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p != null && q != null) {
            return ((p.val == q.val)
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right));
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}