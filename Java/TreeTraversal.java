class TreeTraversal{
	//recursive is easy
	//iterative for pre/in/post-order traversal
	preoder(TreeNode root){
		//conercase
		if (root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()){
			root = stack.pop();
			visit(root);
			if (root.right != null)
				stack.push(root.right);
			if (root.left != null)
				stack.push(root.left);
		}
	}
	inorder(TreeNode root){
		if(root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		while(!stack.isEmpty() || root != null){
			if(root != null){
				stack.push(root);
				root = root.left;
			}
			else{
				visit(stack.peek());
				root = stack.pop().right;
			}
		}
	}
	postoder(TreeNode root){
		if(root == null)
			return null;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode nodeLastVisited = null;
		while(!stack.isEmpty() || root != null){
			if (root != null){
				stack.push(root);
				root = root.left;
			}
			else{
				TreeNode temp = stack.peek();
				if(temp.right != null && temp.right != nodeLastVisited){
					root = temp.right;
				}
				else{
					visit(temp);
					nodeLastVisited = stack.pop();
				}
			}
		}
	}
}