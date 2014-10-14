class Path Sum{
	//is there a non-recursive approach?
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return pathSum(root,root.val,sum);
    }
    private boolean pathSum(TreeNode root, int curr, int sum){
    	if(curr == sum && root.left == null && root.right == null)
    		return true;
    	if(root.left != null){
    		if(pathSum(root.left,curr+root.left.val,sum))
    			return true;
    	}
    	if(root.right != null)
    		if(pathSum(root.right,curr+root.right.val,sum))
    			return true;
    	return false;
    }
}