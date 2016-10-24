public class Solution {
    private static final int[][] DIR= {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0){
            return 0;
        }
        int[][] waterLevel = new int[heightMap.length][heightMap[0].length];
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        for(int i = 0; i < heightMap.length; i++){
            for(int j = 0; j < heightMap[i].length; j++){
                if(!visited[i][j]){
                    dfs(i, j, heightMap, visited, waterLevel);
                }
            }
        }
        
        int trapedWater = 0;
        for(int i = 0; i < waterLevel.length; i++){
            for(int j = 0; j < waterLevel[i].length; j++){
                trapedWater = trapedWater + waterLevel[i][j] - heightMap[i][j];
            }
        }
        
        return trapedWater;
    }
    
    private void dfs(int x, int y, int[][] heightMap, boolean[][] visited, int[][] waterLevel){
        if(x == 0 || x == heightMap.length - 1 || y == 0 || y == heightMap[0].length - 1){
            waterLevel[x][y] = heightMap[x][y];
        }else{
            int curLevel = Integer.MAX_VALUE;
            for(int[] dir : DIR){
                int nextX = x + dir[0];
                int nextY = y + dir[1];
                if(nextX >=0 && nextX < heightMap.length && nextY >=0 && nextY < heightMap[0].length && !visited[nextX][nextY]){
                    
                    visited[nextX][nextY] = true;
                    
                    dfs(nextX, nextY, heightMap, visited, waterLevel);
                    
                    curLevel = Math.min(curLevel, waterLevel[nextX][nextY]);
                }
            }
            waterLevel[x][y] = Math.max(curLevel, heightMap[x][y]);
        }     
    }
    
  
}