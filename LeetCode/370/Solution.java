public class Solution {
    
    public int[] getModifiedArray(int length, int[][] updates) {
        if(updates == null){
            return null;
        }
        
        int[] inc = new int[length + 1];
        int[] arr = new int[length];
        for(int[] update : updates){
            inc[update[0]] += update[2];
            inc[update[1] + 1] -= update[2];            
        }
        arr[0] = inc[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i - 1] + inc[i];     
        }
        
        return arr;
    }
    
}