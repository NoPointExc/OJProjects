public class Solution {

    public boolean isPowerOfFour(int num) {
        int base=1;
        for(int i=0;i<16;i++){
        	System.out.println("i="+i+"base="+base);
            if(base==num) return true;
            base=base*4;
        }
        return false;
    }

}
