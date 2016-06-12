# Definition for a binary tree node.
 class TreeNode
     attr_accessor :val, :left, :right
     def initialize(val)
         @val = val
         @left, @right = nil, nil
     end
end

# @param {TreeNode} root
# @return {Integer}
def sum_numbers(root)
	if root == nil || root.val ==nil
		return 0
	elsif root.left==nil && root.right ==nil
		return root.val
	end

	rst=0
	if root.left!=nil 
		root.left.val+=10*root.val
		rst=sum_numbers(root.left)
	end
	if root.right!=nil
		root.right.val+=10*root.val
		rst+=sum_numbers(root.right)
	end

	return rst   
end

tree=TreeNode.new 10
puts(sum_numbers(tree))
