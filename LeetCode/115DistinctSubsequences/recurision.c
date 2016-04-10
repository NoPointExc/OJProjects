#include <stdio.h>
#include <string.h>

#define NUL '\0'

int numDistinct(char* s, char* t) {
    if(*s==NUL||*t==NUL||strlen(s)<strlen(t)) return 0;    
    char head=*t;
    while(*s!=NUL && *s!=head) s+=1;  
    int count=0;
    if(strlen(t)==1) {
    	while(*s!=NUL){
    		if(*s==*t) count++;
    		s++;
    	}
    	return count;
    }
    if(*s==*t) return numDistinct(s+1,t+1)+numDistinct(s+1,t);
    else return numDistinct(s+1,t);
}

int main(int argc, char const *argv[])
{
	//int ans=numDistinct(argv[0],argv[1]);
	int ans=numDistinct("aaabbbaabba","abba");
	printf("ans=%d\n",ans);
	return 0;
}