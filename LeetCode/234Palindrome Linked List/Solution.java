
public class Solution {
    public boolean isPalindrome(ListNode head) {
       ListNode patrol=head;
       int len=0;
       while(patrol!=null){
       		patrol=patrol.next;
       		len++;
       }
       if(len<2) return true;
       //reverse
       patrol=head.next;
       ListNode base =head;
       head.next=null;
       for(int i=0;i<len/2-1;i++){
       		//System.out.println("i:"+i);
       		ListNode tmp=patrol.next;
       		patrol.next=base;
       		base=patrol;
       		patrol=tmp;
       }       
       //print(patrol);
       //print(base);
       if(len%2==1) patrol=patrol.next;
       for(int i=0;i<len/2;i++){
       		//System.out.println("i:"+i);
       		if(base.val!=patrol.val) return false;
       		base=base.next;
       		patrol=patrol.next;
       }
       return true;
    }

    public void print(ListNode head){
    	ListNode patrol=head;
    	while(patrol!=null){
    		System.out.print(patrol.val+">>");
    		patrol=patrol.next;
    	}
    	System.out.println();
    }

    public ListNode arrToList(int[] arr){
    	ListNode head=new ListNode(-1);
    	ListNode patrol=head;
    	for(int i=0;i<arr.length;i++){
    		patrol.next=new ListNode(arr[i]);
    		patrol=patrol.next;
    	}
    	return head.next;
    }
}