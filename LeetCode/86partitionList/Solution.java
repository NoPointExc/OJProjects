
public class Solution {
    public ListNode partition(ListNode head, int x) {   
        ListNode small=new ListNode(0);
        ListNode large=new ListNode(-2);
        ListNode p1=small;
        ListNode p2=large;
        while(head!=null){
        	if(head.val<x){
        		p1.next=new ListNode(head.val);
        		p1=p1.next;
        	}else{
        		p2.next=new ListNode(head.val);
        		p2=p2.next;
        	}
        	head=head.next;
        }
        p1.next=large.next;
        return small.next;
    }
}