/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include <stdio.h>
#include <stdlib.h>

#define newArray(type,size)  ((type*)calloc(size,sizeof(type)))

int* getRow(int rowIndex, int* returnSize) {
    if(rowIndex<0) return NULL;
    int len=rowIndex+1;
    *returnSize=len;
    int *row=newArray(int,len);
    int i,j;
    for(i=0;i<len;i++)row[i]=1;   
    for(i=0;i<=rowIndex;i++){
    	for(j=i-1;j>0;j--){
    		row[j]=row[j]+row[j-1];
    	}
    }
    return row;
}

int main(int argc, char const *argv[])
{
	int rowIndex=20;
	int *returnSize;
	int *row;
	row=getRow(rowIndex,returnSize);
	int i;
	for(i=0;i<*returnSize;i++){
		printf("%d ",row[i]);
	}
	printf("\n");
	return 0;
}