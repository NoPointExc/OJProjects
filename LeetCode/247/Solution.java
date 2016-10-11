/**
11","69","88","96
--------
111, 181
619, 689, 
818, 888,
916, 986
---------
odd, even,1[]1, 8[]8, 6[]9, 9[]6
odd. ]1[, ]8[
---------
1 6 8 9
9,6
1,1
8,8

*/
public class Solution {
    private static final char[] LEFT= {'0','1', '8', '6', '9'};
    private static final char[] RIGHT= {'0','1', '8', '9', '6'};
    private static final char[] MID= {'0', '1', '8'};
    
    public List<String> findStrobogrammatic(int n) {
        List<String> rstList = new LinkedList<>();
        if(n <=0){
            return rstList;
        }
        backTracking(new char[n], 0, n - 1, true, rstList);
        return rstList;
    }
    
    private void backTracking(char[] curStr, int from, int to, boolean add, List<String> rstList){
        if(from > to){
            rstList.add(new String(curStr));
        }else if(from == to){
            for(int i = 0; i < MID.length; i++){
                curStr[from] = MID[i];
                rstList.add(new String(curStr));    
            }
        }else{
            for(int i = (from == 0 ? 1 : 0); i < LEFT.length; i++){
                curStr[from] = LEFT[i];
                curStr[to] = RIGHT[i];
                backTracking(curStr, from + 1, to - 1, add, rstList);
            }
        }
    }
}