public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int len=obstacleGrid[0].length;
        int wid=obstacleGrid.length;
        if(len==0||wid==0) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        int[][] map=new int[wid][len];
        map[0][0]=1-obstacleGrid[0][0];
        for(int i=1;i<wid;i++) {
            if(map[i-1][0]==1 && obstacleGrid[i][0]==0) map[i][0]=1;
            else map[i][0]=0;
        }
        for(int i=1;i<len;i++) {
            if(map[0][i-1]==1&& obstacleGrid[0][i]==0) map[0][i]=1;
            else map[0][i]=0;            
        }
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