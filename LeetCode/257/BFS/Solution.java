/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public List<String> binaryTreePaths(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		LinkedList<String> strQueue = new LinkedList<String>();
		List<String> rst = new ArrayList<String>();
		if(root == null)
			return rst;

		queue.offer(root);
		strQueue.offer(root.val+"");

		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			String str = strQueue.poll();
			if(node.left == null && node.right == null){
				
			}	
		}
	}
}
