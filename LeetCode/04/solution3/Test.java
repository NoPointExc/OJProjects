class Test{
	public static void main(String[] args) {

		int[] A={1,2,3,4};
		int[] B={1,2,3};
		Solution s=new Solution();
		double ans=s.findMedianSortedArrays(A, B);
		System.out.println("ANS="+ans);
	}

}