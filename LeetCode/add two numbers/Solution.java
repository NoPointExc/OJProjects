
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode result,k;
	    int sum=0, over=0;
	    sum=l1.val+l2.val;
	    over=sum/10;
	    sum=sum%10;
	    result = new ListNode(sum);
	    k=result;
	    l1=l1.next;
	    l2=l2.next;
	    while(l1!=null && l2!=null){
	    	sum=l1.val+l2.val+over;
	    	over=sum/10;
	   		sum=sum%10;
	   		k.next=new ListNode(sum);
	   		k=k.next;
	   		l1=l1.next;
	   		l2=l2.next;
	    }

	    while(l1!=null){
	    	sum=l1.val+over;
	    	over=sum/10;
	   		sum=sum%10;
	   		k.next=new ListNode(sum);
	   		k=k.next;
	   		l1=l1.next;
	   		
	    }

	    while(l2!=null){
	    	sum=l2.val+over;
	    	over=sum/10;
	   		sum=sum%10;
	   		k.next=new ListNode(sum);
	   		k=k.next;
	   		l2=l2.next;
	    }

	    if(over!=0){
	    	k.next=new ListNode(over);
	    }

	    return result;
	}
}