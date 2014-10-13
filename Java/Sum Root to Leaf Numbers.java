class Sum Root to Leaf Numbers{
	private int sum = 0;
	public int sumNumbers(TreeNode root) {
        getSum(0,root);
        return this.sum;
    }
    private void traversalPath(TreeNode root, int pathSum){
    	if(root == null)
    		return;
    	if(root.left == null && root.right == null)
    		sum = sum+pathSum*+root.val;
    	if(root.left != null)
    		traversalPath(root.left,pathSum*10+root.val);
    	if(root.right != null)
    		traversalPath(root.right,pathSum*10+root.val);

    }
}