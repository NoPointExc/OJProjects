#define FALSE 0
#define TRUE 1
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

bool hasPathSum(struct TreeNode* root, int sum) {
 	if(root==NULL) return FALSE;
 	int sum-=root.val;
 	if(sum==0) return TRUE;
 	if(sum<0) return FALSE;
 	return hasPathSum(root->left,sum)||hasPathSum(root->right,sum);
}
