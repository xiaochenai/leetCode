class Binary_Tree_Postorder_Traversal{
	public List<Integer> postorderTraversal(TreeNode root) {

	}
	private void recursive(ArrayList<Integer> res, TreeNode root){
		if(root == null)
			return;
		if(root.left != null)
			recursive(root.left);
		if(root.right != null)
			recursive(root.right);
		res.add(root.val);
		return;
	}
	private void iterative(ArrayList<Integer> res, TreeNode root){
		if(root == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<Integer>();
		TreeNode lastVisited = null;
		while(!queue.isEmpty()||root != null){
			if(root != null){
				queue.offer(root);
				root = root.left;
			}
			else{
				TreeNode temp = queue.peek();
				if(temp.right != null && temp.right != lastVisited){
					root = temp.right;
				}
				else{
					res.add(temp.val);
					queue.pop();
					lastVisited = temp;
				}
			}
		}
	}
}