public class Solution {
    
    private static final int[][] DIR = {{1,0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
    
    
    public void gameOfLife(int[][] board) {
        if(nullOrEmpty(board)){
            return;
        }
        int[][] buf = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                buf[i][j] = nextGen(i, j, board);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = buf[i][j];
            }    
        }
    }
    
    private int nextGen(int x, int y, int[][] board){
        int liveNb = 0, deadNb = 0;
        
        for(int[] dir : DIR){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if(nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length){
                continue;
            }
            if(board[nextX][nextY] == 1){
                liveNb++;    
            }else if(board[nextX][nextY] == 0){
                deadNb++;
            }
        }
        //System.out.println("liveNb="+liveNb+" deadNb="+deadNb);
        if(board[x][y] == 1){
            if(liveNb == 2 || liveNb == 3){
                return 1;
            }else{
                return 0;
            }   
        }else{
            if(liveNb == 3){
                return 1;
            }
        }
        
        return 0;
    }
    
    private boolean nullOrEmpty(int[][] array){
        if(array == null || array.length == 0){
            return true;
        }
        for(int[] sub : array){
            if(sub == null || sub.length == 0){
                return true;
            }
        }
        
        return false;
    }
    
}