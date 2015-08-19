import java.util.*;
public class Solution {
    public int calculate(String s) {
        LinkedList<Integer> stack=new LinkedList<Integer>();
        LinkedList<Integer> pstack=new LinkedList<Integer>();
        int len=s.length();
        int num=0,op=1,ans=0;
        for(int i=0;i<len;i++){
            char now=s.charAt(i);
            if(now==' ') continue;
            
            if(Character.isDigit(now)){              
                num=10*num+Character.valueOf(now)-48;
                
            }else{
                if(stack.size()!=0){
                    int o=stack.pop();
                    int n=stack.pop();
                    num=cal(n,o,num);
                }
                switch(now){
                    case '+':
                        ans=cal(ans,op,num);
                        num=0;
                        op=1;
                        break;
                    case '-':
                        ans=cal(ans,op,num);
                        num=0;
                        op=-1;
                    break;    
                    case '*':
                        stack.push(num);
                        stack.push(2);                      
                        num=0;
                        break;
                    case '/':
                        stack.push(num);
                        stack.push(3);                      
                        num=0;
                        break;
                    case '(':
                        pstack.push(ans);
                        pstack.push(op);
                        ans=0;
                        op=1;
                        break;
                    case ')':
                        num=cal(ans,op,num);
                        op=pstack.pop();
                        ans=pstack.pop();
                        break;
                }
            }
        }

        if(stack.size()!=0){
            int o=stack.pop();
            int n=stack.pop();
            num=cal(n,o,num);
        }
        ans=cal(ans,op,num);
        return ans;
    }

    //-1=-, 1=+, 2=*, 3=/
    private int cal(int num1, int op, int num2){
        
        int ans=0;
        if(op<2){
            ans=num1+op*num2;
        }else if(op==2){
            ans=num1*num2;
        }else{
            ans=num1/num2;
        }
        return ans;
    }
}