class Balanced Binary Tree{
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        return (dep(root) != -1);
    }
    private int dep(TreeNode root){
    	if(root == null)
    		return 0;
    	int left = dep(root.left);
    	int right = dep(root.right);
    	if(left == -1 || right == -1)
    		return -1;
    	if(Math.abs(left-right) > 1)
    		return -1;
    	else
    		return Math.max(left,right)+1;
    }
}