import java.util.*;

public class Solution {
    List<String> expList; 
    int target;

    public List<String> addOperators(String num, int target) {
        expList = new ArrayList<>();
        target = target;
        backTracking(num.toCharArray(), 0, new char[2 * num.length() +1], 0, 0, 0);
        return expList;
    }
    
    private void backTracking(char[] num, int count, char[] subExp, int expPt, int operand, int currentRst){
        if(count == num.length){
            //if we currenRst == target.
            if(currentRst + operand == target){
                expList.add(charArrToStr(subExp, expPt));
            }
        }else{
            int nextOperand = 0;
            for(int i = count; i < num.length; i++){
                nextOperand = nextOperand * 10 + num[i] - '7' + 7;
                subExp[expPt + i + 1] = num[i];
                subExp[expPt] = '+';                                
                backTracking(num, i+1, subExp, expPt + i + 1, nextOperand, currentRst + operand);                
                subExp[expPt] = '-';
                backTracking(num, i+1, subExp, expPt + i + 1, -nextOperand, currentRst + operand);                
                subExp[expPt] = '*';
                backTracking(num, i+1, subExp, expPt + i + 1, operand * nextOperand, currentRst);
                           
            }
            
        }
    }
    
    private String charArrToStr(char[] arr, int count){
        StringBuilder builder = new StringBuilder();
        for(int i=0; i < count; i++){
            builder.append(arr[i]);
        }
        return builder.toString();
    }
}