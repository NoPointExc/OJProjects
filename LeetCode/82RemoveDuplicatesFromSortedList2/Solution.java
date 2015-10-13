/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) { 
      if(head== null || head.next==null) return head;  
      ListNode p=head;
      int pastVal=head.val;
      int pastCt=0;
      ListNode rst=new ListNode(-1);
      ListNode rp=rst;
      int curVal=p.val;
      while(p!=null){    
      curVal=p.val;
      //System.out.println("pastVal="+pastVal+"curVal="+curVal+"pastCt="+pastCt);       
        if(curVal!=pastVal){
          if(pastCt==1) {
            rp.next=new ListNode(pastVal);
            rp=rp.next;
          }
          pastVal=curVal;
          pastCt=1;
        }else{
          pastCt++;
        }
        p=p.next;
      }
      if(pastCt==1)rp.next=new ListNode(pastVal);
      return rst.next;
    }
}