#include <stdlib.h>
#include <stdio.h>

#define newArray(type, size) ((type*)calloc(size, sizeof(type)))
#define hasKids(treeNode) (treeNode->left!=NULL||treeNode->right!=NULL)
struct TreeLinkNode {
	int val;
	struct TreeLinkNode *left,*right,*next;
} treeNode;


void connect(struct TreeLinkNode *root) {
	if(root==NULL) return;
	struct TreeLinkNode *pt=root;
	struct TreeLinkNode** line=newArray(struct TreeLinkNode*,3);
	
	int i=0;
	while(root!=NULL){	
		while(!hasKids(root)){
		 root=root->next;
		 if(root==NULL) return;		
		}		
		pt=root;
		i=0;
		//link all level	
		while(pt!=NULL){
			//fill to line
			if(pt->left!=NULL){
				line[i]=pt->left;
				i++;
			}
			if(pt->right!=NULL){
				line[i]=pt->right;
				i++;
			}
			//link nodes
			if(i==2){
				line[0]->next=line[1];
				line[0]=line[1];
				i=1;
			}else if(i==3){
				line[0]->next=line[1];
				line[1]->next=line[2];
				line[0]=line[2];
				i=1;
			}
			pt=pt->next;	
		}

		root=(root->left!=NULL)?root->left:root->right;		
	}
	free(line);
}

int main(int argc, char const *argv[])
{
	struct TreeLinkNode root;
	struct TreeLinkNode l;
	struct TreeLinkNode ll;
	// ll.val=2;
	// ll.left=NULL;
	// ll.right=NULL;
	// l.val=1;
	// l.left=&ll;
	// l.right=NULL;
	root.val=0;
	//root.left=&l;
	root.left=NULL;
	root.right=NULL;

	connect(&root);
	return 0;
}