#include <stdio.h>
#include <string.h>

#define NUL '\0'

int numDistinct(char const* s, char const* t) {
    if(*s==NUL||*t==NUL||strlen(s)<strlen(t)) return 0;    
    char head=*t;
    while(*s!=NUL && *s!=head) s+=1;  
    if(strlen(t)==1 && *s==*t) return 1;
    return numDistinct(s+1,t+1)+numDistinct(s+1,t);
}

int main(int argc, char const *argv[])
{
	int ans=numDistinct(argv[0],argv[1]);
	printf("ans=%d\n",ans);
	return 0;
}