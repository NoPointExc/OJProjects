class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		ListNode head=new ListNode(0);
		ListNode tmp=head;
		for(int i=1;i<9;i++){
			tmp.next=new ListNode(i);
		}
		if(args.length>0){
			ListNode ans= s.rotateRight(head,Integer.valueOf(args[0]));
			System.out.println(ans);	
		}
		
	}
}