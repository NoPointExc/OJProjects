// a) Insert a character
// b) Delete a character
// c) Replace a character

public class Solution {
  
    public int minDistance(String word1, String word2) { 
      if( word1 == null || word2 == null){
        return -1;
      }
      
      int wordLen1 = word1.length();
      int wordLen2 = word2.length();
      int[][] dp = new int[wordLen1 + 1][wordLen2 + 1];  
      
      for(int i=0; i <= wordLen1; i++){
        dp[i][0] = i;
      }
      
      for(int i=0; i <= wordLen2; i++){
        dp[0][i] = i;
      }
      
      for( int i = 1; i <= wordLen1; i++){  
        for( int j = 1; j <= wordLen2; j++ ){
          if(word1.charAt(i -1) == word2.charAt(j -1)){
            dp[i][j] = dp[i -1][j -1];  
          }else{
            int deleteSteps = dp[i -1][j] + 1;
            int insertSteps = dp[i][j - 1] + 1;
            int replaceSteps = dp[i - 1][j - 1] + 1;
            dp[i][j] = Math.min( Math.min(deleteSteps, insertSteps), replaceSteps);
          }
        }
      }
      
      return dp[wordLen1][wordLen2];
    }
}