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
        if(head==null) return null;
        int len=getLen(head);
        if(len==1) return new TreeNode(head.val);
        int mid=len/2;
        ListNode cur=head;
        ListNode next=cur.next;
        for(int i=1;i<mid;i++) {
            cur=next;
            next=cur.next;
        }
        TreeNode root=new TreeNode(next.val);
        if(next!=null)root.right=sortedListToBST(next.next);
        else root.right=null;
        cur.next=null;
        root.left=sortedListToBST(head);
        return root;
    }
    
    private int getLen(ListNode head){
        //ListNode cur=head;
        int len=0;
        while(head!=null) {
            head=head.next;
            len++;
        }
        return len;
    }
}