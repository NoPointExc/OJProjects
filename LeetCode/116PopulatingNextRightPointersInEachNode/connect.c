#include <stdlib.h>

// #define newArray(type, size) ((type*)calloc(size, sizeof(type)))
// #define resizeArray(ptr, type, size) ((type*)realloc(ptr, (size) * sizeof(type)))

struct TreeLinkNode {
	int val;
	struct TreeLinkNode *left,*right,*next;
};

void connect(struct TreeLinkNode *root) {
	if(root==NULL) return;
	struct TreeLinkNode *cur;
	while(root->left!=NULL){
		cur=root;			
		cur->left->next=cur->right;		
		while(cur->next!=NULL){			
			cur->right->next=cur->next->left;
			cur=cur->next;
			cur->left->next=cur->right;
		}
		root=root->left;
	}    
}