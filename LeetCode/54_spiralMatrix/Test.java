import java.util.*;
class Test{
	public static void main(String[] args) {
		Solution s=new Solution();
		int[][] matrix=getMat(3,4);
		List<Integer> ans= s.spiralOrder(matrix);

		System.out.println(ans);
	}

	public static int[][] getMat(int len,int wid){
		int[][] matrix=new int[len][wid];
		
		for(int i=0;i<len;i++){
			for(int j=0;j<wid;j++) {
				System.out.print(i*wid+j+1+"    ");	
				matrix[i][j]=i*wid+j+1;
			}
			System.out.println();
		}
		return matrix;
	}
}