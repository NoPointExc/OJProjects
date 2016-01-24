/*
Question 3
烙饼问题

**/

/******SOlution 1: 
1）找到最大数 max  2）把max 翻到顶 3）把max 翻到底
**/

int [] pancake={1,4,2,3 };
 int n=pancake.getSize();
 boolean sort(int n ){
	int i=n;
 	if(pancake[n]!=n){
 	while(pancake[i]!=n) i--;
 	//把最大的饼翻到最上面
 	if(i!=0) overturn(i);
 	//把最大的饼又翻到最下面
 	overturn(n);
   }
   	n--;
   	if(n==0) return true;
 	this.sort(--n);	
 }
 void overturn(int i){
 	int top=0;
 	int end=pancake.getSize();
 	while(top>end){
 		//反转最上最下位置
 		int tmp=pancake[top];
 		pancake[top]=pancake[end];
 		pancake[end]=tmp;
 		top++;
 		end--;
 	}
 }