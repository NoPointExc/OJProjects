import java.lang.System;
import java.util.*;

public class Palindromic{

		//consider the mirror palindromic inside a palindromic
        //case 0: inner mirror cut with range
        //case 1: inner mirror inside the range
        //case 3: inner mirror out the range 
         
        public char[] getLongest2(char[] in){
            if(in==null || in.length==0) return in;
            char[] str=preInsert(in);
            int c=0,r=1,max=0;
            int R[]=new int[str.length];
            Arrays.fill(R,0);
            
			while(c+r<str.length){
				while(c-R[c]-1>=0 && c+R[c]+1<str.length && str[c+R[c]+1]==str[c-R[c]-1]){
                    R[c]++;
                }
                if(R[c]>R[max]) max=c;

                if(r<=R[c]){
                    if(r+R[c-r]<R[c]){
                        R[c+r]=R[c-r];
                        r++;
                    }else if(r+R[c-r]>R[c]){
                        R[c+r]=R[c]-r;
                        r++;    
                    }else{
                        R[c+r]=R[c-r];
                        c=c+r;
						r=1;
                    }
                }else{
					c=c+r;
					r=1;
                }
            }
            
			char[] ans=new char[R[max]];
			int count=0;
			for(int n=max-R[max];n<=max+R[max];n++){
				if(n%2==1) {
					ans[count++]=str[n];
				}
			}

			return ans;            
		}

		public char[] getLongest(char[] in){
			if(in==null) return null;
			if(in.length==0) return new char[0];
			char[] str=preInsert(in);
			int max=0, c=0,i=0;
			int R[]=new int[str.length];
			Arrays.fill(R,0);

			while( i<str.length && c+R[c]<str.length){
				if(i<c+R[c]){
					if(i+R[2*c-i]==c+R[c]){
						//cut
						R[i]=R[2*c-i];
						c=i;
						//i=c+R[c];
					}else if(i+R[2*c-i]<c+R[c]){
						//inner
						R[i]=R[2*c-i];
						i++;
					}else{
						//out
						R[i]=c+R[c]-i;
						i++;
					}
				}else{
					while( c+R[c]+1<str.length && c-R[c]-1>=0 && str[c+R[c]+1]==str[c-R[c]-1]){
						R[c]++;
					}
					c=i;
					i++;

				}
			}

			for(int n=0;n<R.length;n++){
				max=R[n]>R[max]?n:max;
			}

			//System.out.println("max="+max);
			char[] ans=new char[R[max]];
			int count=0;
			for(int n=max-R[max];n<=max+R[max];n++){
				if(n%2==1) {
					ans[count++]=str[n];
				}
			}

			return ans;
		}

		private char[] preInsert(char [] str){
			int len=str.length;
			char[] ans=new char[2*len+1];
			for(int i=0;i<ans.length;i++){
				if(i%2==0) ans[i]='$';
				else ans[i]=str[i/2];
			}
			return ans;
		}

		public static void main(String[] args){
			Palindromic s=new Palindromic();
			//char[] str="abcdefedefedcbbabc".toCharArray();
			char[] str="bbbb".toCharArray();
			//char[] str="".toCharArray();
			char[] ans2=s.getLongest2(str);
			for(char c:ans2) System.out.print(c+" ");
			System.out.println();		
			char[] ans=s.getLongest(str);
			//char[] ans=s.preInsert(str);
			for(char c:ans) System.out.print(c+" ");
			System.out.println();
		}

}
