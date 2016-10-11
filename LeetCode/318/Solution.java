public class Solution {
    
    public int maxProduct(String[] words) {
        if(words == null && words.length == 0){
            return 0;
        }
        
        int[] map = new int[words.length];
        
        for(int i = 0; i < words.length; i++){
            if(words[i] != null){
                for(int j = 0; j < words[i].length(); j++){
                    map[i] = map[i] | (1 << (words[i].charAt(j) - 'a'));
                }        
            }
        }
        
        int maxProduct = 0;
        for(int i = 0; i < words.length; i++){
            for(int j = i + 1; j < words.length; j++){
                if((map[i] & map[j]) == 0 && (words[i].length() * words[j].length() > maxProduct)){
                    maxProduct = words[i].length() * words[j].length();
                }       
            }
        }
        
        return maxProduct;
    }
}    