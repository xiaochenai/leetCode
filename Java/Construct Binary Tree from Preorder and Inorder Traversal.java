class Construct Binary Tree from Preorder and Inorder Traversal{
	//root,left,right
	//left,root,right
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,preorder.length-1,0,inorder.length-1,preorder,inorder);
    }
    private TreeNode build(int preStart,int preEnd,int inStart,int inEnd,int[] preorder,int[] inorder){
    	if(preStart>preEnd || inStart > inEnd){
    		return null;
    	}
    	int rootVal = preorder[preStart];
    	TreeNode root = new TreeNode(rootVal);
    	int rootIndex = inStart;
    	while(rootIndex <= inEnd){
    		if(inorder[rootIndex] == rootVal)
    			break;
    		rootIndex++;
    	}
    	//left len = rootIndex-1 - instart + 1
    	TreeNode left = build(preStart+1,preStart+rootIndex-inStart,inStart,rootIndex-1,preorder,inorder);
    	TreeNode right = build(preStart+rootIndex-inStart+1,preEnd,rootIndex+1,inEnd,preorder,inorder);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}