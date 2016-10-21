public class Solution {
    private static final int[][] DIR = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null){
            return null;
        }
        
        List<int[]> rstList = new LinkedList<>();
        if(matrix.length == 0 || matrix[0].length == 0){
            return rstList;
        }
        
        boolean[][] reachPacific = floding(matrix, true);
        boolean[][] reachAltantic =  floding(matrix, false);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(reachPacific[i][j] && reachAltantic[i][j]){
                    rstList.add(new int[]{i, j});
                }
            }
        }
        
        return rstList;
    }
  
    private boolean[][] floding(int[][] matrix, boolean isPacific){
        boolean[][] canReach = new boolean[matrix.length][matrix[0].length];
        LinkedList<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < matrix.length; i++){
            int y = isPacific ? 0 : matrix[0].length -1;
            canReach[i][y] = true;
            queue.offer(new int[]{i, y}); 
        }
        
        for(int j = 0; j < matrix[0].length; j++){
            int x = isPacific ? 0 : matrix.length -1;
            canReach[x][j] = true;
            queue.offer(new int[]{x, j}); 
        }
        
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            //visit
            canReach[cur[0]][cur[1]] = true;
            for(int[] dir : DIR){
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if( nextX >=0 && nextX < matrix.length && nextY >=0 && nextY < matrix[nextX].length && !canReach[nextX][nextY] && matrix[nextX][nextY] >= matrix[cur[0]][cur[1]]){
                    queue.offer(new int[]{nextX, nextY});
                }
            }
        }
        
        return canReach;
    }
}