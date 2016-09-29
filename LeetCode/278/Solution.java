/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //binary search
    public int firstBadVersion(int n) {
        //two pointer, h alway be the good version, t always be the bad version. 
       	
        long lastGood = 0L, firstBad=(long)n;
        
        while(lastGood < firstBad-1){
        	long mid = (firstBad + lastGood) / 2;
        	//System.out.println(mid);
        	if( isBadVersion((int)mid) ){
        		firstBad = mid;
        	}else{
        		lastGood = mid;
        	}
        }

        return (int)firstBad;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int rst = s.firstBadVersion(1702766719);
    	System.out.println(rst);
    }
}