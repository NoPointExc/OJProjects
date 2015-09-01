import java.util.*;
public class Solution {
    Map<int[],Integer> map=new HashMap<int[],Integer>();   
    public int minPathSum(int[][] grid) {
        int len=grid[0].length;
        int wid=grid.length;
        int[][] map=new int[wid][len];
        //init
        map[0][0]=grid[0][0];
        for(int x=1;x<wid;x++)
            map[x][0]=map[x-1][0]+grid[x][0];
        for(int y=1;y<len;y++)
            map[0][y]=map[0][y-1]+grid[0][y];       
        for(int ox=1,oy=1;wid>1 && len>1;){
            for(int x=ox;x<wid;x++)
                map[x][oy]=Integer.min(map[x-1][oy],map[x][oy-1])+grid[x][oy];         
            for(int y=oy+1;y<len;y++)
                map[ox][y]=Integer.min(map[ox][y-1],map[ox-1][y])+grid[ox][y];
            if(ox==wid-1 && oy==len-1) break;
            if(ox<wid-1) ox++;
            if(oy<len-1) oy++;
            //System.out.println("ox="+ox+" oy="+oy);
        }
        //print
        // for(int x=0;x<wid;x++){
        //     for(int y=0;y<len;y++)
        //         System.out.print("  "+map[x][y]);
        //     System.out.println();
        // }
        return map[wid-1][len-1];
    }
}