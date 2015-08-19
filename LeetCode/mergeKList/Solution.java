
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len=lists.length;
        if(len==0) return null;
        if(len==1) return lists[0];
        int ansLen=len/2+len%2;   
        ListNode[] ans=new ListNode[ansLen];
        for(int i=0;i<ansLen-1;i++){
        	ans[i]=mergeTwoLists(lists[2*i],lists[2*i+1]); 	
        }
        if(len%2==0) ans[ansLen-1]=mergeTwoLists(lists[2*ansLen-2], lists[2*ansLen-1]);
        else ans[ansLen-1]=lists[2*ansLen-2];   
        return mergeKLists(ans);      
    }



     private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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