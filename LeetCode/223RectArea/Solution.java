public class Solution {
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	long share=0;
    	if(A>C){
    		int tmp=A;
    		A=C;
    		C=tmp;
    	}
    	if(E>G){
    		int tmp=E;
    		E=G;
    		G=tmp;
    	}
    	if(D<B){
    		int tmp=D;
    		D=B;
    		B=tmp;
    	}
    	if(H<F){
    		int tmp=H;
    		H=F;
    		F=tmp;
    	}
        int w0,w1,h0,h1;        
        h0=Math.min(D,H);
        h1=Math.max(B,F);
        w0=Math.max(A,E);
        w1=Math.min(C,G);
        System.out.println("h0,"+h0+"  h1,"+h1+"  w0,"+w0+"  w1"+w1);
        long h=(long)h0-h1;
        long w=(long)w1-w0;
        if(h>0&&w>0) share=(long) h*w;
        
        return (int)((C-A)*(D-B)+(H-F)*(G-E)-share);
    }
}