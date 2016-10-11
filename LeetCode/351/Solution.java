public class Solution {
    public int numberOfPatterns(int m, int n) {
        int patternCount= 0;
        
       
        patternCount += 4 * routeCount(0, 0, 1, m, n,new boolean[3][3]) + 4 * routeCount(0, 1, 1, m, n, new boolean[3][3]) + routeCount(1, 1, 1, m, n, new boolean[3][3]);
        
        
        return patternCount;
    }
    
    private int routeCount(int x, int y, int count, int min, int max, boolean[][] map){
        int patternCount = 0;
        
        if(count == max){
            return 1;
        }else{
            if(count >= min){
                patternCount ++;
            }
            //for every possible next node, mark and call routeCount
            int nextX = x, nextY = y;
            for(int i = -2; i <= 2; i++){
                for(int j = -2; j <= 2; j++){
                    if(i == 0 && j != 1 && j != -1){
                        continue;
                    }
                    if(i == 2 && j != 1 && j != -1){
                        continue;
                    }
                    nextX = x + i;
                    nextY = x + j;

                    if(nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[nextX].length && !map[nextX][nextY]){
                        map[nextX][nextY] = true;
                        patternCount += routeCount(nextX, nextY, count + 1, min, max, map);
                        map[nextX][nextY] = false;
                    }       
                }
            }
            
        }
        
        return patternCount;
    }
}