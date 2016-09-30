public class Solution {
    public int numSquares(int n) {
		if(n < 0){
			return -1;
		}

		int squareNum = n;

		int root = (int)Math.sqrt(n);
		if( n % (root * root) == 0){
			return n / (root * root);
		}else{
			for(int i=root; i>=1; i--){
				int num = numSquares(n % (i * i)) + n / (i * i); 
				squareNum = Math.min(num, squareNum);
			}
		}

		return squareNum;    
    }
}