
import java.lang.Math.*;
public class Solution {

	private static void print(ListNode ln, String tag){
		System.out.println("********"+tag+"**********");
		while(ln!=null){
			System.out.print(ln.val+",  ");
			ln=ln.next;
		}
		System.out.println();
		System.out.println("#######################");
	}
   
    public ListNode sortList(ListNode head) {
    	System.out.println("*****sortList*****");
        //merge sort
        //3,5,7,9,1,2,6,8,10
        if(head==null) return null; //length=0
        if(head.next==null) {print(head,"head");return head;} //length=1
        
        	int length=getLength(head);//length=9
        	System.out.println("*****length*****");
        	System.out.println(length);
        	int middle=(int)Math.floor(length/2);//middle=4
        	System.out.println("*****middle*****");
        	System.out.println(middle);

        	//get the ListNode just before middle
        	ListNode tmp= indexAt(head, middle-1); //9, index@4
        	print(tmp,"tmp");
        	ListNode rightTmp=tmp.next; //rightTmp=1,2,6,8,10
        	print(rightTmp,"rightTmp");
        	tmp.next=null;	//head=3,5,7,9
        	ListNode leftTmp=head;//leftTmp=3,5,7,9
        	print(leftTmp,"leftTmp");
        	ListNode left=sortList(leftTmp); //left=3,5,7,9
        	ListNode right=sortList(rightTmp); //right=1,2,6,8,10
        	print(left,"left");
        	print(right, "right");
        	ListNode merged=merge(left,right);
       		return  merged;   
   		
    }

    
    /**
    *merge left and right
    */
    //left                , right
    // left>>3             right>> 5
    //merge
    //merge>> 0,1 
    public ListNode merge(ListNode left, ListNode right){
    	ListNode merged;
    	ListNode pointer;
    	if(left==null&&right!=null)  return right;
    	if(right==null&&left!=null)  return left;

    	//new merged
    	if(left.val<right.val){//3<5 true
    		//left<right
    		merged =new ListNode(left.val); //merged>>3
    		left=left.next;   //left=null, right=5
    	}else{//3>1
    		merged=new ListNode(right.val);
    		right=right.next;
    	}
    	pointer=merged; //pointer=1
    	//merge left & right
    	//*******************
    	//while left and right not null
    	while(left!=null && right!=null){ 
    		if(left.val<right.val){
    			//left<right
    			ListNode next=new ListNode(left.val);
    			pointer.next=next;
    			left=left.next;
    			//pointer ++
    			pointer=pointer.next;
    		}else{
    			//right<left
    			ListNode next=new ListNode(right.val);
    			pointer.next=next;
    			right=right.next;
    			//pointer ++
    			pointer=pointer.next;
    		}

    	}
    	//merge excess left  into merged
    	while(left!=null){
    		ListNode next=new ListNode(left.val);
    		pointer.next=next;
    		left=left.next;
    		//pointer ++
    		pointer=pointer.next;
    	}
    	//merge excess right into merged
    	while(right!=null){
    		ListNode next=new ListNode(right.val);
    		pointer.next=next;
    		right=right.next;
    		//pointer ++
    		pointer=pointer.next;
    	}

    return merged;
    }



    /**
    *get length
    */
    private int getLength(ListNode ln){
    	
    	int len=0;
    	while(ln!=null){
    		len++;
    		ln=ln.next;
    	}
    	return len;
    }

    /**
    *get ListNode at index
    */
    private ListNode indexAt(ListNode head, int index){
    	ListNode indexAt;
    	indexAt=head;		
    	for(int i=0;i<index;i++){
    		indexAt=indexAt.next;
    	}
    return indexAt;	
    }
}