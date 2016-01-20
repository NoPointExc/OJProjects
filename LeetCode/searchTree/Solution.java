 public class Solution{
	public void travel(TreeNode root){
		TreeNode cur=root;
		while(cur!=null){
			//if left node is null
			if(cur.left==null) {
				System.out.println(cur.val);
				cur=cur.right;
			}
			else{
				boolean visited=false;
				TreeNode next=cur.left;
				while(next.right!=null){
					if(next.right!=cur)next=next.right;
					else{
						//System.out.println(next.val);
						next.right=null;
						visited=true;
					}
				}
				if(!visited) {
					next.right=cur;						
				}
				cur=cur.left;
			}			
		}
	}
}