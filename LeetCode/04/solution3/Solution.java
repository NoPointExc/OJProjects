public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
 		int[] n,m;
 		if(nums1.length<nums2.length){
 			n=nums1;
 			m=nums2;
 		}else{
 			n=nums2;
 			m=nums1;
 		}
 		if(n.length==0) return m[m.length/2+m.length%2];

 		int mid=(n.length+m.length)/2+(n.length+m.length)%2;
 		int ln=0,hn=n.length;
 		while(ln<hn){
 			System.out.println("ln="+ln+",  hn="+hn+", mid="+mid);
 			int midn=(ln+hn)/2;
 			int midm=mid-midn-1;
 			if(midm>=m.length){
 				ln=midn;
 			}if(n[midn]>=m[midm+1]){
 				//midn cover midm, larger midm, smaller midn
 				hn=midn;
 			}else if(m[midm]>=n[midn]+1){
 				//midm cover midn, smaller midm, larger midn
 				ln=midn;
 			}else{
 				//get result
 				
 				if((n.length+m.length)%2==0){
 					return ((double)(n[midn]+m[midm]))/2;
 				}else{
 					return Math.max(n[midn],m[midm]);
 				}
 			}
 		}
 		return -1.0;
    }
}