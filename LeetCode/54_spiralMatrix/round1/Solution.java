import java.util.*;	
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<Integer> ();
        if(matrix.length==0) return ans;
        int row=matrix.length, 	col=matrix[0].length;
        int left=0, top=0;
        int cell=row*col-1;
        ans.add(matrix[0][0]);
       	int i=0,j=0;
        while(cell>0){
        	for(j=j+1;j<col && cell>0;j++){
        		cell--;
        		ans.add(matrix[i][j]);
        	}
        	top++;
        	j=j-1;
        	for(i=i+1;i<row && cell>0;i++){
        		cell--;
        		ans.add(matrix[i][j]);
        	}
        	col--;
        	i=i-1;
        	for(j=j-1;j>=left && cell>0;j--){
        		cell--;
        		ans.add(matrix[i][j]);
        	}
        	row--;
        	j=j+1;
        	for(i=i-1;i>=top && cell>0;i--){
        		cell--;
        		ans.add(matrix[i][j]);
        	}
        	left++;	
        	i=i+1;       	
        }
        return ans;
    }
}