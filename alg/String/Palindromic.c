#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int getLongest(char* str, char* rst)
{
	int len=strlen(str);
	bool tab[len][len];
	memset(tab,false,sizeof(tab));
	for(int i=0;i<len;i++) tab[i][i]=true;
	int begin=0;
	int max=1;
	
	//len<2
	for(int i=0;i<len-1;i++)
	{	
		if(str[i]==str[i+1]) 
		{
			tab[i][i+1]=true;
			if(max==1)
			{
				max=2;
				begin=i;
			}
		}
	}

	//len>=2
	for(int l=3;l<=len;l++)
	{
			for(int i=0;i<len-l;i++)
			{
				// i ,i+1,... j-1,j
				int j=i+l-1;
				if(tab[i+1][j-1] && str[i]==str[j])
				{
					tab[i][j]=true;
					if(max<l)
					{
						max=l;
						begin=i;
					}
				}
			}
	}
	
	//return value
	strncpy(rst,&str[begin],max);
	rst[max]='\0';
	return 1;
}


int main()
{
	char str[]="rqewrabcdcbasafaf";
	char rst[strlen(str)];
	memset(rst,'\0',sizeof(str));
	getLongest(str,rst);
	printf("rst=%s\n",rst);
	return 1;
}
