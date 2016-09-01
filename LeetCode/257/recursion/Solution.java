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
		List<String> rst = new ArrayList<String> ();
		if(root == null)
			return rst;	
		List<String> ll = binaryTreePaths(root.left);
		List<String> rl = binaryTreePaths(root.right);
		
		for(String str:ll){
			rst.add(addToHead(root.val,str));
		}

		for(String str:rl){
			rst.add(addToHead(root.val,str));
		}

		if(rst.size() == 0){
			rst.add(root.val+"");
		}

		return rst;
	}

	private String addToHead(int val, String str){
		return val+"->"+str;
	}
}
