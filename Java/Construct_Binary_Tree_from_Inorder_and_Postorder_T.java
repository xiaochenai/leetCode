class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal{
	//inorder:left,root,right postorder:left,right,root
	//1,2,3,4,5,6,7
	//in:4 2 5 1 6 3 7
	//post: 4 5 2 6 7 3 1
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        return rebuildTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    private TreeNode rebuildTree(int[] inorder,int inStart, int inEnd,int[] postorder,int postStart,int postEnd){
    	if(inStart>inEnd || postStart > postEnd)
    		return null;
    	int rootVal = postorder[postEnd];
    	TreeNode root = new TreeNode(rootVal);
    	int rootIndex = inStart;
    	while(rootIndex<=inEnd){
    		if(inorder[rootIndex] == rootVal)
    			break;
    		rootIndex++;
    	}
    	//k=rootIndex-startIndex
    	//be careful with the index
    	//numofItem = index2-index1+1
    	//index2 = index1+numofItem-1
    	TreeNode left = rebuildTree(inorder,inStart,rootIndex-1,postorder,postStart,postStart+rootIndex-inStart-1);
    	TreeNode right = rebuildTree(inorder,rootIndex+1,inEnd,postorder,postStart+rootIndex-inStart,postEnd-1);
    	root.left = left;
    	root.right = right;
    	return root;
    }
}
