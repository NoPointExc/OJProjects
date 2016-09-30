// 314.    Binary Tree Vertical Order Traversal
// 题目：

// Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

// If two nodes are in the same row and column, the order should be from left to right.

// Examples:
// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
 

// return its vertical order traversal as:

// [
//   [9],
//   [3,15],
//   [20],
//   [7]
// ]
 

// Given binary tree [3,9,20,4,5,2,7],

//     _3_
//    /   \
//   9    20
//  / \   / \
// 4   5 2   7
 

// return its vertical order traversal as:

// [
//   [4],
//   [9],
//   [3,5,2],
//   [20],
//   [7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class Solution {
    private class TreeColumnNode{
        public TreeNode treeNode;
        int col;
        public TreeColumnNode(TreeNode node, int col) {
            this.treeNode = node;
            this.col = col;
        }
    }
    
    public List<List<Integer>> verticalOrder(TreeNode root) {    
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if( root == null){
            return rst;
        }
        int max=0, min=0;
        HashMap<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();
        
        Queue<TreeColumnNode> queue=new LinkedList<TreeColumnNode>();
        queue.offer(new TreeColumnNode(root,0));
        
        while(!queue.isEmpty()){
            TreeColumnNode p=queue.poll();
            List<Integer> list;
            if(map.containsKey(p.col)){
                list=map.get(p.col);
            }else{
                list=new ArrayList<Integer>();
            }
            list.add(p.treeNode.val);
            map.put(p.col,list);

            if(p.treeNode.left!=null){
                if(p.col-1<min) min=p.col-1;
                queue.offer(new TreeColumnNode(p.treeNode.left,p.col-1));
            }

            if(p.treeNode.right!=null){
                if(p.col+1>max) max=p.col+1;
                queue.offer(new TreeColumnNode(p.treeNode.right,p.col+1));
            }
        }

        for(int i=min;i<=max;i++){
            List<Integer> list;
            if(map.containsKey(i)){
                list=map.get(i);
            }else{
                list=new ArrayList<Integer>();
            }
            rst.add(list);
        }

        return rst;
    }

}