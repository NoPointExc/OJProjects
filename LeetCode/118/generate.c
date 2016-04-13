#include <stdlib.h>
#include <stdio.h>

#define newArray(type, size) ((type*)calloc(size, sizeof(type)))


int** generate(int numRows, int** columnSizes) {
 	   printf("**");
 	   if(numRows<=0) return NULL;
 	   int** row=newArray(int*,numRows);
 	   columnSizes=newArray(int*,numRows);
 	   int i=0,j=0;
 	   for(i=0;i<numRows;i++){
 	   		*columnSizes[i]=i;
 	   		row[i]=newArray(int,i+1); 	   		
			for(j=0;j<numRows;j++){
				if((j-1)<0 || (j+1)>(i-1)) row[i][j]=1;
				else row[i][j]=row[i-1][j-1]+row[i-1][j+1];
			}
 	   } 	   
 	   return row;
}

int main(void){	
	printf("*");
	int size=5;
	//int** columnSizes;
	int** columnSizes=newArray(int*,size);
	**columnSizes=0;
	// columnSizes[0]=1;
	// columnSizes[0]=2;
	// columnSizes[0]=3;
	// columnSizes[0]=4;
	//printf("%d",**columnSizes);
	//int** ans=generate(size,columnSizes);
	int i=0,j=0;
	//for(i=0;i<size;i++){
		//printf("%d\n",(int)sizeof(**columnSizes));
		//printf("%d",*(*columnSizes+1));
		//for(j=0;j<*columnSizes[i];j++){
			//printf("%d ",ans[i][j]);
		//}
		printf("\n");
	//}
	return 0;
}