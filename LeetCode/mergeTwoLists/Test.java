class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		ListNode h1=new ListNode(0);
		ListNode h2=new ListNode(1);
		ListNode p1=h1;
		ListNode p2=h2;
		for(int i=1;i<10;i++){
			p1.next=new ListNode(2*i);
			p2.next=new ListNode(2*i+1);
			p1=p1.next;
			p2=p2.next;
		}
		print(h1);
		print(h2);

		ListNode h3=null; ListNode h4=new ListNode(0);
		ListNode ans= s.mergeTwoLists(h3,h4);
		System.out.println("**ANS**");
		print(ans);		
	}

	private static void print(ListNode l){
		while(l!=null){
			System.out.print(l.val+", ");
			l=l.next;
		}
		System.out.println();
	} 
}