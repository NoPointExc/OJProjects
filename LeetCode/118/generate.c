#include <stdlib.h>
#include <stdio.h>

#define newArray(type, size) ((type*)calloc(size, sizeof(type)))


int** generate(int numRows, int** columnSizes) {
 	   //printf("**\n");
 	   if(numRows<=0) return NULL;
 	   *columnSizes = (int*)malloc(sizeof(int) * numRows); 	   
 	   int** row=newArray(int*,numRows);
 	   int i=0,j=0;
		
	   //for(i=0;i<numRows;i++) row[i]=newArray(int,i+1);
 	   for(i=0;i<numRows;i++){
 	   		int len=i+1;
 	   		row[i]=(int*)malloc(sizeof(int) * len);
 	   		(*columnSizes)[i]=len;
 	   		for(j=0;j<numRows;j++){
				if((j-1)<0 || j>(i-1)) row[i][j]=1;
				else row[i][j]=row[i-1][j-1]+row[i-1][j];
			}
 	   }	   
 	   return row;
}

int main(void){	

	//printf("*\n");
	int size=20;
	int** columnSizes;
	int** ans=generate(size,columnSizes);
	int i=0,j=0;
	// printf("%d\n",(int)sizeof(*columnSizes));
	// printf("*\n");		
	for(i=0;i<size;i++){
		//for(j=0;j<=i;j++){
		for(j=0;j<(*columnSizes)[i];j++){
			printf("%d ",ans[i][j]);
		}
		printf("\n");
	}
	return 0;
}