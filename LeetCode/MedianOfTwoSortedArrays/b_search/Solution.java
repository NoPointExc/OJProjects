public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int[] A, B;
   		int a,b; //pointer for A and B
       if(nums1.length>nums2.length) {
       	A=nums1; B=nums2;
    	}else{
    	A=nums2;B=nums1;	
    	}
    	int m=A.length,n=B.length;//length of A & B
    	//half A, util find midian
    	a=m-1;b=n-1;
    	int mid=(m+n)/2-1+(m+n)%2; //the num of num that < median
    	System.out.println("mid="+mid);
    	System.out.println("*********************");
    	while(a>1){
    		//get result
    		if(a+b==mid){
    			System.out.println("a="+a+" ,b="+b+"=");
    			return (A[a]>B[b])?A[a]:B[b];
    		}
    		if(a+b>mid){
    			System.out.println("a="+a+" ,b="+b+">");
    			a=a/2;
    			b=bSearch(B,0,b,A[a]);
    		}else{
    			System.out.println("a="+a+" ,b="+b+"<");
    			a=a/2+a/4;
    			b=bSearch(B,b,n,A[a]);
    		}
    	}
    	return -1;
    }
    //the num that <target
    //start, end: the range for search. tgt: the target num that search for. 
    public int bSearch(int[] arr,int start, int end, int tgt){
    	if(tgt>arr[end]) return end;
    	if(tgt<arr[start]) return start;
    	if(end==start) return start;
    	if(arr[(start+end)/2]<=tgt&&arr[(start+end)/2+1]>=tgt) return (start+end)/2;
    	if(tgt>arr[(start+end)/2]){
    		return bSearch(arr, (start+end)/2+1,end,tgt );
    		}else{
    		return bSearch(arr, start, (start+end)/2-1,tgt );
    	}
    }
	
}