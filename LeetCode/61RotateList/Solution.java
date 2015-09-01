
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len=0;
        ListNode tail=head;
        len=getLen(head,tail);
        int index=len-k;
        if(index==0) return head;
        ListNode newTail=head;
        for(int i=1;i<index;i++){
        	newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        
        newTail.next=null;
        tail.next=head;
        
        return newHead;
    }
    private int getLen(ListNode head,ListNode tail){
    	int len=0;
    	while(tail.next!=null) {
    		len++;
    		tail=tail.next;
    	}
    	return len+1;
    }
}