public class Solution {
    
    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int left = 0, right = 0;
        int count = 0;
        int leftLen = 0;
        while(left < s.length() && s.charAt(left) != '['){
            if(s.charAt(left) >= '0' && s.charAt(left) <= '9'){
                count = count * 10 + s.charAt(left) - '0';
            }else{
                leftLen++;
            }
            left++;
        }
        if(left == s.length()){
            return s;
        }
        right = left + 1;
        int leftCount = 1;
        while(right < s.length() && leftCount > 0){
            if(s.charAt(right) == ']'){
                leftCount--;
            }
            if(s.charAt(right) == '['){
                leftCount++;
            }
            right++;
        }
        
        String sub = decodeString(s.substring(left + 1, right - 1));
        StringBuilder strBuilder = new StringBuilder(s.substring(0, leftLen));
        for(int i = 0; i < count; i++){
            strBuilder.append(sub);
        }
        strBuilder.append(decodeString(s.substring(right)));
        
        return strBuilder.toString();
    }
}