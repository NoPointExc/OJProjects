
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root==null) return;
       	TreeLinkNode line[]=new TreeLinkNode[3];
        int i=0;
        while(root!=null){
        	while(root.left==null && root.right==null){
        		root=root.next;
        		if(root==null) return;
        	}
        	TreeLinkNode pt=root;
        	i=0;
        	while(pt!=null){
        		//fill to line
				if(pt.left!=null){
					line[i]=pt.left;
					i++;
				}
				if(pt.right!=null){
					line[i]=pt.right;
					i++;
				}
				//link nodes
				if(i==2){
					line[0].next=line[1];
					line[0]=line[1];
					i=1;
				}else if(i==3){
					line[0].next=line[1];
					line[1].next=line[2];
					line[0]=line[2];
					i=1;
				}
				pt=pt.next;
        	}

			root=(root.left!=null)?root.left:root.right;		
        }
    }
}