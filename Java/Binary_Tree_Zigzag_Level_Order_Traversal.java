class Binary_Tree_Zigzag_Level_Order_Traversal{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return res;
        int level = 1;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	int len = stack.size();
        	ArrayList<Integer> solution = new ArrayList<Integer>();
        	ArrayList<TreeNode> treeArray = new ArrayList<TreeNode>();
        	for(int i=0;i<len;i++){
        		treeArray.add(stack.pop());
        	}
        	for(TreeNode tr:treeArray){
        		solution.add(tr.val);
        		if(level%2 == 1){
        		    if(tr.left != null)
        			    stack.push(tr.left);
        			if(tr.right != null)
        			    stack.push(tr.right);
        		}
        		else{
        		    if(tr.right != null)
        		    	stack.push(tr.right);
        		    if(tr.left != null)
        			    stack.push(tr.left);
        		}
        	}
        	level = (level+1)%2;
        	res.add(solution);
        }
        return res;
    }
}