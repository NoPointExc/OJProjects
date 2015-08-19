import java.util.*;
public class Solution {
    public ListNode reverseList(ListNode head) {
        Stack<Integer> buff=new Stack();
        ListNode pt=head;
        while(pt!=null){
        	buff.push(pt.val);
        	pt=pt.next;
        }
        ListNode ans=new ListNode(0);
        pt=ans;
        while(!buff.empty()){
        	pt.next=new ListNode(buff.pop());
        	pt=pt.next;
        }
        return ans.next;
    }
}