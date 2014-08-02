/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 //按层处理
 //1.找出下一层的起始点N，用一个指针K去连接下一层
 //2.获取当前层的起始点C，同时C也用于指示我们访问到的当前层的位置
 //3.若N为空的时候说明下一层还没开始访问，此时若有sub不为空那么N=sub, k=sub
 //4.若N不为空，表示已经开始下一层的访问了，找出当前的下一层指针k，k.next = sub
 //5.内循环的终止条件为当前层访问完毕，外循环终止条件为下一层访问完毕
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode current = root;
		TreeLinkNode next = null;//next level's first node
		while (current != null){
			TreeLinkNode k = null;//current pointer of next level
			while (current != null){
				TreeLinkNode subNode = nextChildNode(current);//first child node of current node
				if (subNode != null){
					if (next == null){
						next = subNode;
						k = subNode;
					}
					else{
						k.next = subNode;
					}
					while (k.next != null)
						k = k.next;
				}
				current = current.next;
			}
			current = next;
			next = null;
		}
		
    }
	private TreeLinkNode nextChildNode(TreeLinkNode root){
		if (root.left != null && root.right != null){
			root.left.next = root.right;
		}
		if (root.left != null)
			return root.left;
		if (root.right != null)
			return root.right;
		return null;
	}
}

//1.非逐层访问
//2.每层从右向左访问
//3
public class Solution {
    public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		TreeLinkNode next = root.next;
		while (next != null){
			if (next.left != null){
				next = next.left;
				break;
			}
			if (next.right != null){
				next = next.right;
				break;
			}
			next = next.next;
		}
		if (root.right != null){
			root.right.next = next;
		}
		if (root.left != null){
			if (root.right != null)
				root.left.next = root.right;
			else
				root.left.next = next;
		}
		connect(root.right);
		connect(root.left);
    }

}
