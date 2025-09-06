/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generateSubtree(1, n);
    }

    private List<TreeNode> generateSubtree(int left, int right) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftSubtrees = generateSubtree(left, i - 1);
            List<TreeNode> rightSubtrees = generateSubtree(i + 1, right);

            for (TreeNode l: leftSubtrees) {
                for (TreeNode r : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
