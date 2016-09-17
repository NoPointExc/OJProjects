public class Solution {
    
    public int countNumbersWithUniqueDigits(int n) {
	if(n<0)
	    return 0;
	if(n==0)
	    return 1;

	int rst = 10;
	int aviableNum = 9;
	int uniqueNum = 9;
	for(int i=n;i>1 && aviableNum>0;i--){
	    uniqueNum *= aviableNum;
	    rst += uniqueNum;
	    aviableNum--;
	}

	return rst;
    }

    public static void main(String args[]){
	Solution s = new Solution();
	int rst = s.countNumbersWithUniqueDigits(Integer.parseInt(args[0]));
	System.out.println("rst="+rst);
    }

}
