class Flatten Binary Tree to Linked List{
	public void flatten(TreeNode root) {
        iterative(root);
    }
    private TreeNode recursive(TreeNode root){
    	if(root == null)
    		return null;
    	TreeNode lHead = recursive(root.left);
    	TreeNode rHead = recursive(root.right);
    	root.left = null;//this is important
    	if(lHead != null){
    		root.right = lHead;
    		while(lHead.right != null)
    			lHead = lHead.right;
    		lHead.right = rHead;
    	}
    	else
    		root.right = rHead;
    	return root;
    }
    private void iterative(TreeNode root){
    	if(root == null)
    		return;
    	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    	stack.push(root);
    	TreeNode pre = null;
    	while(!stack.isEmpty()){
    		TreeNode current = stack.pop();
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push(current.left);
            if(pre != null){
                pre.left = null;
                pre.right = current;
            }
            pre = current;
    	}
    }
}