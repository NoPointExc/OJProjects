public class Solution {
	private int[][] matrix;
	int len;
	int wid;

    public boolean searchMatrix(int[][] matrix, int target) {
    	this.matrix=matrix;
       	len=matrix.length;
       	if(len==0) return false;
        wid=matrix[0].length;
        int max=len*wid-1;
        int h=0;
        int t=max;
        while(h<t-1){
        	int m=(h+t)/2;
        	if(at(m)<target){
        		h=m;
        	}else if(at(m)>target){
        		t=m;
        	}else return true;
        	//System.out.println("("+h+","+t+")");
        }

        return (at(h)==target) || (	at(t)==target) ;
    }

    public int at(int i){
    	return matrix[i/wid][i%wid];
    }
}