class Validate Binary Search Tree{
	public boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
    }
    private boolean isValid(TreeNode root,int upBound, int lowBound){
    	if(root == null)
    		return true;
    	if(!(root.val< upBound && root.val > lowBound))
    		return false;
    	return isValid(root.left,root.val,lowBound) && isValid(root.right,upBound,root.val);
    }
}