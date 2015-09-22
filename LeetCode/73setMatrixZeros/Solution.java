public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean l0=false,c0=false;
        for(int i=0;i<matrix[0].length;i++){
        	l0|=(matrix[0][i]==0);
        }

        for(int i=0;i<matrix.length;i++){
        	c0|=(matrix[i][0]==0);
        }

        for(int x=1;x<matrix.length;x++){
        	for(int y=1;y<matrix[0].length;y++){
        		if(matrix[x][y]==0) {
        			matrix[x][0]=0;
        			matrix[0][y]=0;
        			break;
        		}
        	}
        }

        //set ZERO
        for(int i=1;i<matrix.length;i++){
        	for(int j=1;j<matrix[0].length;j++){
        		if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
        	}
        }
    


        if(l0) for(int i=0;i<matrix[0].length;i++) matrix[0][i]=0;
        if(c0) for(int i=0;i<matrix.length;i++) matrix[i][0]=0;


    }
}