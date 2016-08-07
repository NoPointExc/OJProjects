public class Solution2 {
    public int numDecodings(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1){
            if(s.charAt(0)=='0') return 0;
            else return 1;
        }
        
        int[] arr=toIntArr(s);
        int[] num=new int[s.length()];
        if(arr[0]==0) return 0;
        if(arr[0]!=1 && arr[0]!=2 && arr[1]==0) return 0;
        num[0]=1;
        num[1]=(arr[0]*10+arr[1]<=26 && arr[0]*10+arr[1]>=10)?2:1;
        
        for(int i=2;i<s.length();i++){
            if(arr[i]==0){
                if(arr[i-1]==1 || arr[i-1]==2){
                    num[i]=num[i-2];
                }else{
                    return 0;
                }    
            }else{
                if(arr[i-1]*10+arr[i]<=26 && arr[i-1]*10+arr[i]>=10){
                    num[i]=num[i-1]+num[i-2];
                }else{
                    num[i]=num[i-1];
                }   
            } 
        }
        
        return num[s.length()-1];
    }
    
    private int[] toIntArr(String s){
        int[] arr=new int[s.length()];
        for(int i=0;i<s.length();i++){
            arr[i]=0-'0'+s.charAt(i);
        }
        return arr;
    }
}