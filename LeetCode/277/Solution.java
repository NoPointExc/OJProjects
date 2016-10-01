import java.util.*;
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        if(n <=0 ){
            return -1;
        }
        if( n == 1){
            return 1;
        }
        
        int [][] relations = new int[n][n]; // -1 do not knwon, 0 unknown realation, 1 knwon, i known j
        int celebrity = 0;
        for(int i = 1; i < n; i++){
            if(knows(celebrity, i)){
                relations[celebrity][i] = 1;
                celebrity = i;                
            }else{
                relations[celebrity][i] = -1;
            }
        }
        
        for(int i = 0; i < n; i++){
            if(i != celebrity && relations[celebrity][i] == 0 && knows(celebrity, i)){      
                return -1;
            }
            if(i != celebrity && relations[i][celebrity] == 0 && !knows(i, celebrity)){
                return -1;
            }
        }
        
        return celebrity;
    }
}