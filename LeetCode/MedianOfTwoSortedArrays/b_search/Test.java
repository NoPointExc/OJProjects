public class Test{
	public static void main(String[] args) {
		int[] A={1,3,5};
		int[] B={1,3};
		Solution s=new Solution();
		double ans=s.findMedianSortedArrays(A, B);
		//int ans=s.bSearch(A,0,A.length-1,2);
		System.out.println("ANS="+ans);
	}
}