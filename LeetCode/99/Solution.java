 public class Solution{
	public void travel(TreeNode root){
		TreeNode cur=root;
		while(cur!=null){
			//if left node is null
			if(cur.left==null) {
				//visit
				System.out.println(cur.val);
				cur=cur.right;
			}
			else{
			//if left node is not null
				TreeNode next=cur.left;
				while(next.right!=null)
					next=next.right;
				next.right=cur;	
				cur=cur.left;
			}			
		}
	}
}