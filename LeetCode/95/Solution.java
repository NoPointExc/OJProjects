import java.util.*;
public class Solution {
   
    public List<TreeNode> generateTrees(int n) {
        int[] nodes=new int[n];
        for(int i=0;i<n;i++) nodes[i]=i+1;
        return recur(nodes);
    }

    private List<TreeNode> recur(int[] nodes){
    	 List<TreeNode> trees=new LinkedList<TreeNode>();
    	if( nodes==null||nodes.length==0 ) return trees;
    	
    	//pick a root
    	for(int i=0;i<nodes.length;i++){
    		
    		int[] lNodes=null;
    		if(i>0) lNodes=Arrays.copyOfRange(nodes,0,i);
    		int[] rNodes=null;
    		if(i+1<nodes.length) rNodes=Arrays.copyOfRange(nodes,i+1,nodes.length);
    		List<TreeNode> lTrees=recur(lNodes);
    		List<TreeNode> rTrees=recur(rNodes);
    		if(lTrees.isEmpty() && rTrees.isEmpty()){
    			TreeNode tree=new TreeNode(nodes[0]);
    			trees.add(tree);
    		}else if(lTrees.isEmpty()){
    			for(TreeNode rt:rTrees){
    				TreeNode tree=new TreeNode(nodes[i]);
    				tree.right=rt;
    				trees.add(tree);
    			}
    		}else if(rTrees.isEmpty()){
    			for(TreeNode lt:lTrees){
	    			TreeNode tree=new TreeNode(nodes[i]);
	    			tree.left=lt;
	    			trees.add(tree);
    			}    			
    		}else{
    			for(TreeNode lt:lTrees){
    				for(TreeNode rt:rTrees){
    					TreeNode tree=new TreeNode(nodes[i]);
    					tree.left=lt;
    					tree.right=rt;
    					trees.add(tree);
    				}
    			}
    		}

    	}
    
    	return trees;
    }
}