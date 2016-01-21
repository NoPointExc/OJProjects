import java.util.*;
public class Solution {
	int[] preorder,inorder;
	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||preorder.length!=inorder.length) return null;
        this.preorder=preorder;
        this.inorder=inorder;
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return buildTree(0,preorder.length,0);
    }

    private TreeNode buildTree(int head,int tail,int rootPos){
        if(rootPos>=preorder.length) return null;
        TreeNode root=new TreeNode(preorder[rootPos]);
        int mid=map.get(preorder[rootPos]);
        if(head<mid) root.left=buildTree(head,mid,rootPos+1);
        if(mid+1<tail) root.right=buildTree(mid+1,tail,rootPos+1);
        return root;
    }

    private int search(int[] arr,int num){
    	for(int i=0;i<arr.length;i++) if(num==arr[i]) return i;
    	return -1;
    }
}