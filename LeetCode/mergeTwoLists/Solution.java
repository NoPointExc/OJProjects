/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       	ListNode ans=new ListNode(0);
       	ListNode pa=ans;
       	ListNode p1=l1;
       	ListNode p2=l2;
       	while(p1!=null && p2!=null){
       		if(p1.val<p2.val){
       			pa.next=new ListNode(p1.val);
       			p1=p1.next;
       		}else{
       			pa.next=new ListNode(p2.val);
       			p2=p2.next;
       		}
       		pa=pa.next;
       	}
       	while(p1!=null){
       		pa.next=new ListNode(p1.val);
       		p1=p1.next;
       		pa=pa.next;
       	}
       	while(p2!=null){
       		pa.next=new ListNode(p2.val);
       		p2=p2.next;
       		pa=pa.next;
       	}
        return ans.next;
    }
}