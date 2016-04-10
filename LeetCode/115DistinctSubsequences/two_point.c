#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
int numDistinct(char* s, char* t) {
	int len_s=strlen(s);
	int len_t=strlen(t);
	int ans=0;
	//calloc:init-value= 0, alloc->no init-value
	int (*arr)[len_s]=(int (*)[len_s])calloc(len_s*len_t,sizeof(int));	
	int is,it;	
	arr[0][0]=(s[0]==t[0]?1:0);
	
	for(is=1;is<len_s;is++){
		arr[0][is]=arr[0][is-1];
		arr[0][is]+=(s[is]==t[0]?1:0) ;
	}

	for(it=1;it<len_t;it++){		
			
		for(is=1;is<len_s;is++){
			//printf("%s\n","hi" );
			arr[it][is]=arr[it][is-1];
			if(s[is]==t[it]) arr[it][is]+=arr[it-1][is-1];			
		}
	}
	free(arr);
	return arr[len_t-1][len_s-1];
}

int main() {
	char s[] = "acbbcaa";
	char t[] = "ca";
	int ans=numDistinct(s, t);
	printf("ans=%d\n",ans);
	return 0;
}