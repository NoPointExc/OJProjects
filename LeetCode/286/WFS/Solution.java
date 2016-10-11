public class Solution {
    private static final int[][] DIR = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length ==0 || rooms[0].length == 0){
            return;
        }
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dp(i, j, rooms);
                }
            }
        }
    }
    
    private void dp(int x, int y, int[][] rooms){
        LinkedList<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(x, y));
        while(!queue.isEmpty()){
           
            Pos cur = queue.poll();
            for(int[] dir : DIR){
                int nextX = dir[0] + cur.x;
                int nextY = dir[1] + cur.y;
                if(nextX >= 0 && nextX < rooms.length && nextY >= 0 && nextY < rooms[0].length && rooms[nextX][nextY] != -1){
                    if(rooms[nextX][nextY] > rooms[cur.x][cur.y] + 1){
                        rooms[nextX][nextY] = rooms[cur.x][cur.y] + 1;
                        queue.offer(new Pos(nextX, nextY));    
                    }
                }
            }
            
        }
    }
    
    static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}