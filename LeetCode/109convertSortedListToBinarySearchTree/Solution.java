/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        int len=getLen(head);
        if(len==0) return null;
        int mid=len/2;
        ListNode cur=new ListNode(-1);
        cur.next=head;
        for(int i=0;i<mid-1;i++) cur=cur.next;
        TreeNode root=new TreeNode(cur.next.val);
        if(mid+1<len) root.right=sortedListToBST(cur.next.next);
        cur.next=null;
        if(mid>0) root.left=sortedListToBST(head);
        return root;
    }
    
    private int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null) {
            cur=cur.next;
            len++;
        }
        return len;
    }
}