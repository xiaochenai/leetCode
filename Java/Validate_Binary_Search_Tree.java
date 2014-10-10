class Validate_Binary_Search_Tree{
	public boolean isValidBST(TreeNode root) {
        boolean a = isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        boolean b = isValid(root,false,false,Integer.MAX_VALUE,Integer.MIN_VALUE);
        boolean c=  isValid2(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return c;
    }
    private boolean isValid(TreeNode root, int rightMin, int leftMax){
    	if(root == null)
        	return true;
        if(root.val <= rightMin || root.val >= leftMax)
        	return false;
        return isValidBST(root.left,rightMin,root.val) && isValidBST(root.right,root.val,leftMax);
    }
    private boolean isValid(TreeNode root, boolean left, boolean right, int rightMin, int leftMax){
    	if(root == null)
        	return true;
        if(left && root.val >= leftMax)
        	return false;
        if(right && root.val <= rightMin)
        	return false;
        return isValid(root.left,true,right,rightMin,root.val) && isValid(root.right,left,true,root.val,leftMax);

    }
    private boolean isValid2(TreeNode root,int rightMin, int leftMax){
    	if(root == null)
        	return true;
        if(root.left != null && (root.left.val >= root.val || root.left.val <= rightMin))
        	return false;
        if(root.right != null && (root.right.val <= root.val || root.right.val >= leftMax))
        	return false;
        return isValid2(root.left,rightMin,root.val) && isValid2(root.right,root.val,leftMax);
    }_
}
class TreeNode {
    int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}