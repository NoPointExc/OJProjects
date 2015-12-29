//1->2->3->4->5->6->7->8->NULL, 2<->6
//
//1->6->5->4->3->2->7->8->NULL
//1->4->3->2->5->NULL.
 
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head.next==null) return head;
        ListNode zero=new ListNode(0);
        zero.next=head;
        ListNode h=zero;
        int hi;
        for(hi=1;hi<m;hi++) h=h.next;
        ListNode t=h.next;
        ListNode tBefore=h.next;
        for(int ti=hi+1;ti<=n;ti++){
        	if(t.next!=null){
        		t=t.next;
        		//swap h.next and t        	
        		tBefore.next=t.next;
        		t.next=h.next;
        		h.next=t;
        		//revocer pointer
        		t=tBefore;
        	}else{
        		t.next=h;
        		h.next=null;
        	}
        }
        return zero.next;
    }
}