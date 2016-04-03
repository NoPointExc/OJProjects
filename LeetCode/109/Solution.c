#include <stdio.h>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

//Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
struct TreeNode* sortedListToBST(struct ListNode* head) 
{
    int len=get_len(head);
    struct ListNode* rootNode=head;
    int i;
    for(i=0;i<(len/2);i++) rootNode=rootNode->next;
    struct TreeNode *right=sortedListToBST(rootNode->next);
	rootNode->next=NULL;
	struct TreeNode *left=sortedListToBST(head);
	TreeNode root;
	root.val=rootNode.val;
	root->left=left;
	root->right=right;
	return root;
}

int get_len(struct ListNode* head)
{	
	if(head==NULL) return 0;
	int len=1;
	while((head=head->next)!=NULL) len++;
	return len;
}