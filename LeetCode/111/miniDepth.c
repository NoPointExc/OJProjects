// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
#include <stdio.h>
#include <stdlib.h>
#include "TreeNode.h"

int minDepth(struct TreeNode* root) 
{
    if(root==NULL) return 0;
    if(root->left==NULL && root->right==NULL) return 1;
    int l_depth=minDepth(root->left);
    int r_depth=minDepth(root->right);
    if(l_depth==0) return r_depth+1;
    if(r_depth==0) return l_depth+1;
    return l_depth<r_depth?(l_depth+1):(r_depth+1);
}

int main(int argc, char const *argv[])
{
	
	return 0;
}