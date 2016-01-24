
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        if(len==0) return null;
        int mid=len/2;
        TreeNode root=new TreeNode(nums[mid]);
        if(mid>0) root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,mid));
        if(mid+1<len) root.right=sortedArrayToBST(Arrays.copyOfRange(nums,mid+1,len));
        return root;
    }
}