class Binary Tree Maximum Path Sum{
	private int maxV = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int nonCross = findPathSum(root);
        return Math.max(nonCross,this.maxV);
    }
    private int findPathSum(TreeNode root){
    	if(root == null)
    		return 0;
    	int left = findPathSum(root.left);
    	int right = findPathSum(root.right);
    	int cross = left + right + root.val;
    	int non_cross = Math.max(root.val,root.val+Math.max(left,right));
    	maxV = Math.max(cross,non_cross);
    	return non_cross;
    }
}