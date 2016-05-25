#!/usr/bin/env ruby
# @param {Integer[]} nums

# @param {Integer} target

# @return {Integer[]}

def two_sum(nums, target)	
	map={}
	ans=[]
	for i in 0..nums.length 
		if map[nums[i]]!=nil
			ans[0]=map[nums[i]]
			ans[1]=i
			return ans
		end
		map[target-nums[i]]=i
	end
end

#print two_sum([2,7,11,15],9)
