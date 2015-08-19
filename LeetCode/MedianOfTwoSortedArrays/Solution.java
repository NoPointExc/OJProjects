/**
*There are two sorted arrays A and B of size m and n respectively. 
*Find the median of the two sorted arrays. 
*The overall run time complexity should be O(log (m+n)).
*/
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
    	if(A.length==0&&B.length==0) return -1.0;
    	if(A.length==0) {
    		if(B.length%2==1){
    			return B[B.length/2];
    		}
    		return 0.5*(B[B.length/2]+B[B.length/2-1]);
    	}
    	if(B.length==0){
    		if(A.length%2==1){
    			return A[A.length/2];
    		}
    		return 0.5*(A[A.length/2]+A[A.length/2-1]);
    	}

    	int len=A.length+B.length;
    	boolean isEven=false;
    	int C[]=new int[len/2+1];
    	int a=0,b=0;

    	for(int i=0;i<C.length;i++){
    		if(a>A.length-1){
    			C[i]=B[b];
    			b++;
    		}else if(b>B.length-1){
    			C[i]=A[a];
    			a++;
    		}else{
    			if(A[a]<B[b]){
    				C[i]=A[a];
    				a++;
    			}else{
    				C[i]=B[b];
    				b++;
    			}
    		}

    	}
    	for(int i=0;i<C.length;i++){
    		System.out.print(C[i]);
    	}
    	System.out.println();
    	if(len%2==1) return C[C.length-1];
    	return 0.5*(C[C.length-1]+C[C.length-2]);
    }

}