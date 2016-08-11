public class Solution {
    public int nthUglyNumber(int n) {
        
        int[] ind={2,2,4};//i1=1,i3=2,i5=4;
        int[] fac={2,3,5};// f2=2,f3=3,f5=5;
        int len=n>5?n:5;
        int[] arr=new int[len];
        
        for(int i=0;i<5;i++){
            arr[i]=i+1;
        }
        
        for(int i=5;i<n;i++){
            int min=getMin(fac[0]*arr[ind[0]],fac[1]*arr[ind[1]],fac[2]*arr[ind[2]]);
            for(int j=0;j<3;j++){
                if(fac[j]*arr[ind[j]]==min){
                    arr[i]=min;
                    ind[j]++;
                }
            }
        }
        
        return arr[n-1];
    }
    
    private int getMin(int a,int b,int c){
        return Math.min(Math.min(a,b),c);
    }
}