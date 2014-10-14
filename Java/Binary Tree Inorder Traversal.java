class Binary Tree Inorder Traversal{
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root == null)
        	return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(!stack.isEmpty() || root != null){
        	if(root!=null){
        		stack.push(root);
        		root = root.left;
        	}
        	else{
        		root = stack.pop();
        		res.add(root.val);
        		root = root.right;
        	}
        }
        return res;
    }
}