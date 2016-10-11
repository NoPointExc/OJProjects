public class Solution {
    private static final int INF = Integer.MAX_VALUE;
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == INF){
                    dp(i, j, rooms);    
                }
            }
        }
    }
    
    private int dp(int x, int y, int[][] rooms){
        if(x < 0 || y < 0 || x >= rooms.length || y >= rooms[x].length || rooms[x][y] == -1){
            return INF - 1;
        }else if(rooms[x][y] == 0){
            return 0;
        }
        rooms[x][y] = -1;
        int min = Math.min(dp(x + 1, y, rooms), dp(x - 1, y, rooms));
        min = Math.min(min, dp(x, y + 1, rooms));
        min = Math.min(min, dp(x, y - 1, rooms));
        rooms[x][y] = min + 1;
        return rooms[x][y];
    }
}