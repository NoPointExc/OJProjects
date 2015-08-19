/**
*Sort a linked list in O(n log n) time using constant space complexity.
*/
public class Solution {
    public ListNode sortList(ListNode head) {
        ListNode tail=getTail(head);
        return quickSort(head, tail).next;
    }

    public ListNode getTail(ListNode ln){
    	if(ln==null) return null;
    	while(ln.next!=null) {
            ln=ln.next;
        }
		return ln;
    }

    public ListNode quickSort(ListNode head, ListNode tail){
    	if(head==null) return null;
    	if(head==tail) return head;
    	ListNode midTmp;
    	if(head.next!=tail || head!=tail){
    		//sort input
            ListNode[] result=partSort(head, tail); 
            //devide into sub1 and sub2
    		ListNode head1=head;
            result[0].next=null;
            ListNode tail1=result[0];
            ListNode head2=tail;
            ListNode tail2= result[1];
            //sort sub1 and sub2
    		ListNode lHead=quickSort(head1,tail1 );
    		ListNode rHead=quickSort(head2, tail2);
    		ListNode lTail=getTail(lHead);
            //combine sub1 and sub2
            lTail.next=rHead;
            head=lHead;
    	}
       
    	//print(head);
    	return head;
    }
    //part sort solution, return midle listNode
    //return mid, which is the node just before the key node. head is also cuted down after
    //return the new tail, the pTail last position
    //this point
    public ListNode[] partSort(ListNode head, ListNode tail){
    	ListNode mid;
    	//ListNode[] result={head,mid};
    	ListNode pTail=tail;
    	ListNode pLast=head;
    	ListNode pHead=head;
    	//sort into two grop, lefts<tail, right>tail
    	while(pHead!=tail){
    		if(pHead.val>tail.val){
    			//insert after tail
    			ListNode tmp=new ListNode(pHead.val);
    			pTail.next=tmp;
    			pTail=pTail.next;
    			//delete pHead
    			if(pHead==head) head=head.next; 
    			pLast.next=pHead.next;
    			pHead=pHead.next;
    		}else{
    			//tail>pHead, no operation on pTail, pHead & pLast move forward
    			pLast=pHead;
    			pHead=pHead.next;
    		}	
    		
    	}
    	mid	= pLast;;
    	//System.out.println("tail: " +tail.val+"  ;  tail.next: "+tail.next.val+" ; head: "+ head.val);
    	ListNode[] result={mid,pTail };
        return result;
    }

   	private static void print(ListNode ln){
		System.out.println("********START**********");
		while(ln!=null){
			System.out.print(ln.val+",  ");
			ln=ln.next;
		}
		System.out.println();
		System.out.println("********END**********");
	}
}