public class Solution {
    
    public boolean canWin(String s) {
        if(s == null){
            return false;
        }
        
        for(int i = 0; i + 1 < s.length(); i++){
            if(s.startsWith("++", i)){
                if(!canWin(s.substring(0,i) + "--" + s.substring(i + 2))){
                    return true;
                } 
            }     
        }
        
        return false;
    }
    
}