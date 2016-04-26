#include <stdio.h>
#include <stddef.h>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void flatten(struct TreeNode* root) {
 	   struct TreeNode *r_most;
 	   while(root){ 	   
 	   		if(root->left){ 	   			
 	   			if(root->right){ 	   				
 	   				r_most=root->left;
	 	   			while(r_most->right){
	 	   				r_most=r_most->right;
	 	   			}
	 	   			r_most->right=root->right; 	   				
 	   			}
 	   			root->right=root->left;
 	   			root->left=NULL;
 	   			root=root->right;
 	   		}else{
 	   			root=root->right;
 	   		}
 	   }
}
