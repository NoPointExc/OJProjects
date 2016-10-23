/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLen(headA);
        int lenB = getLen(headB);
        ListNode small = headA, large = headB;
        if(lenA > lenB){
            small = headB;
            large = headA;
        }
        
        for(int diff = Math.abs(lenA - lenB); diff > 0; diff--){
            large = large.next;
        }
        
        while(small != null && large !=null && small != large){
            small = small.next;
            large = large.next;
        }
        
        return small;
    }
    
    private int getLen(ListNode node){
        int len = 0;
        while(node != null){
            len++;
            node = node.next;
        }
        return len;
    }
}