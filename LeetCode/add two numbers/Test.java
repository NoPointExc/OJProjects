public class Test{
	static int[] l1Arr={3,5,7,9,1,2,6,8,10};
	static int[] l2Arr={3,5,7,9,1,2,6,8,10};
	
	private static ListNode init(int[] in){
		ListNode input=new ListNode(in[0]);
		ListNode p=input;
		for(int i=1;i<in.length;i++){
			ListNode next=new ListNode(in[i]);
			p.next=next;
			p=next;
		}
		return input;	
	}
	private static void print(ListNode ln, String tag){
		System.out.println("********"+tag+"**********");
		while(ln!=null){
			System.out.print(ln.val+",  ");
			ln=ln.next;
		}
		System.out.println();
		System.out.println("*********************");
	}

	public static void main(String[] args) {
		ListNode l1=init(l1Arr);
		ListNode l2=init(l2Arr);
		Solution s=new Solution();
		ListNode ans=s.addTwoNumbers(l1,l2);
		print(ans,"ANS");
	}



}