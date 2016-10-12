public class Solution {
    
    public boolean validTree(int n, int[][] edges) {
        if(edges == null){
            return false;
        }
        if(edges.length == 0){
            return n == 1;
        }
        
        boolean[][] map = new boolean[n][n];
        for(int[] edge : edges){
            map[edge[0]][edge[1]] = true;
            map[edge[1]][edge[0]] = true;
        }
        int[] visitCount = new int[n];
        bfs(0, map, visitCount);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j]){
                    return false;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(visitCount[i] != 1){
                return false;
            }
        }
        return true;
    }
    
    private void bfs(int node, boolean[][] map, int[] visitCount){
        LinkedList<Integer> nextNodes = new LinkedList<>();
        nextNodes.offer(node);
        
        while(!nextNodes.isEmpty()){
            int curNode = nextNodes.poll();
            //visit
            visitCount[curNode] += 1;
            for(int i = 0; i < map.length; i++){
                if(map[curNode][i]){
                    nextNodes.offer(i);
                    map[curNode][i] = false;
                    map[i][curNode] = false;
                }
            }
        }
        
    }
  
}