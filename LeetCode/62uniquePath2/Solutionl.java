public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len=obstacleGrid.length;
        int wid=obstacleGrid[0].length;
        int[][] map=new map[len][wid];
        for(int i=0;i<len;i++) map[i][0]=1;
        for(int i=0;i<wid;i++) map[0][i]=1;
        for(int i=1;i<wid;i++){
        	for(int j=1;j<len;j++){
        		if(obstacleGrid[i][j]==1) map[i][j]=0;
        		else{
        			map[i][j]=map[i-1][j]+map[i][j-1];
        		}

        	}
        }
        return map[wid-1][len-1];      
    }
}