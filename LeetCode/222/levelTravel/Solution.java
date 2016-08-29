import java.util.*;

/**
 *TLE
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int countNodes(TreeNode root) {
		if(root==null)
			return 0;
		ArrayList<TreeNode> thisLevel = new ArrayList<TreeNode>();
		ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
		thisLevel.add(root);
		
		int count = 0;
		while(thisLevel.size()!=0){
			for(TreeNode node:thisLevel){
				count++;
				if(node.left!=null)
					nextLevel.add(node.left);
				if(node.right!=null)
					nextLevel.add(node.right);
			}
			thisLevel = nextLevel;
			nextLevel = new ArrayList<TreeNode>();
		}
	
		return count;
	}
}
