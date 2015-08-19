public class Solution {

    public void rotate(int[][] matrix) {
        int size=matrix[0].length;
        int[][] copy=new int[size][size];
        //print(matrix);
        //System.out.println("******fold*****");
        for(int i=0;i<size/2;i++){
        	for(int j=0;j<size;j++){
        		swap(matrix,i,j,size-1-i,j);
           	}           	
        }
        //print(matrix);
        //System.out.println("******reflect********");
        for(int i=0;i<size;i++){
        	for(int j=0;j<i;j++){
        		swap(matrix,i,j,j,i);
        	}
        }
        //print(matrix);
    }

    private void swap(int[][] matrix,int fx,int fy, int tx, int ty){
    	matrix[fx][fy]=matrix[fx][fy]^matrix[tx][ty];
    	matrix[tx][ty]=matrix[fx][fy]^matrix[tx][ty];
    	matrix[fx][fy]=matrix[fx][fy]^matrix[tx][ty];
    }
    public void print(int[][] arr){
    	for(int i=0;i<arr[0].length;i++){
    		for(int j=0;j<arr[0].length;j++){
    			System.out.print(arr[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}