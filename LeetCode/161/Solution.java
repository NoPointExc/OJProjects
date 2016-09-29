public class Solution {
    
    public boolean isOneEditDistance(String s, String t) {
      if( s== null || t == null)
        return false;
      char[] shortStr = s.toCharArray(), longStr = t.toCharArray();
      if(s.length() > t.length()){
        shortStr = t.toCharArray();
        longStr = s.toCharArray();
      }
      
      int left = 0, right = 1;
      //scan from left -- > right
      while(left < shortStr.length &&  shortStr[left] == longStr[left]){
        left++;
      }
      
      while(left <= shortStr.length -right && shortStr[shortStr.length - right] == longStr[longStr.length - right]){
        right++;
      }
      
      return left + right == longStr.length;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	boolean rst = s.isOneEditDistance("a", "ba");
    	System.out.println(rst);
    }

}