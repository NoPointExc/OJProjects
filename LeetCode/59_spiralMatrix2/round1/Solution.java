public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matr=new int[n][n];
        int num=n*n, cur=1;
       	int left=0, top=0, btm=n, right=n;
       	int i=0,j=0; //i@top--btm, j@ left--right
        while(cur<=num){
        	//System.out.println(">>>>>>>>>>>>>>>");
        	for(j=left;j<right && cur<=num;j++){
        		//System.out.println("i:"+i+" j:"+j);
        		matr[i][j]=cur;	
        		cur++;
        	}
        	top++;
        	j--;
        	//System.out.println("vvvvvvvvvvvvvvvv");
        	for(i=top;i<btm && cur<=num;i++){
        		//System.out.println("i:"+i+" j:"+j);
        		matr[i][j]=cur;
        		cur++;
        	}
        	right--;
        	i--;
        	//System.out.println("<<<<<<<<<<<<<<<<<<");
        	for(j=right-1;j>=left && cur<=num;j--){
        		//System.out.println("i:"+i+" j:"+j);
        		matr[i][j]=cur;
        		cur++;
        	}
        	btm--;
        	j++;
        	//System.out.println("^^^^^^^^^^^^^^^^^^");
        	for(i=btm-1;i>=top && cur<=num;i-- ){
        		//System.out.println("i:"+i+" j:"+j);
        		matr[i][j]=cur;
        		cur++;
        	}
        	left++;
        	i++;
        }
        return matr;
    }
}