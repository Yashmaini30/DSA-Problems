class Solution {
    private TreeNode ans;
    private int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        helper(root,0);
        return ans;
    }
    private int helper(TreeNode root, int depth){
        if(root==null){
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        } 

        int left = helper(root.left,depth + 1);
        int right = helper(root.right,depth + 1);

        if(left == maxDepth && right == maxDepth){
            ans = root;
        }
        return Math.max(left,right);
    }
}
