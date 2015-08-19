class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[] list={0,2,2,1};
		ListNode head=s.arrToList(list);
		s.print(head);
		boolean ans= s.isPalindrome(head);
		System.out.println(ans);

	}


}