public class Solution {
	public int kthSmallest(TreeNode root, int k) {
		int count = 0;
		TreeNode p = root;
		LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
		
		while(p!=null || !stack.isEmpty()){
			if(p==null){
				p = stack.pop();
				count++;
				if(count==k)
					break;
				p = p.right;
			}else{
				stack.push(p);
				p = p.left;		
			}
		}

		return p.val;
	}
}

