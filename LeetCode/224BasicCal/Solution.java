import java.util.*;
public class Solution {
    public int calculate(String s) {
        LinkedList<Integer> stack=new LinkedList<Integer>();
        int result=0, sign=1, num=0;
        for(int i=0;i<s.length();i++){
            char now=s.charAt(i);           
            switch(now){
                case ' ': continue;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    result=0;
                    sign=1;
                    break;
                case '+':               
                    result+=sign*num;
                    sign=1;
                    num=0;
                    break;
                case '-':
                    result+=sign*num;
                    sign=-1;
                    num=0;
                    break;
                case ')':
                    num=result+sign*num;
                    sign=stack.pop();
                    result=stack.pop();                 
                    break;
                default: 
                    if(Character.isDigit(now)){
                        num=10*num+Character.valueOf(now)-48;
                    }
                    
            }
            System.out.println("res:"+result+"num:"+num+"sign:"+now);
        }
        result+=sign*num;
        return result;
    }
}