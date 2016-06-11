# @param {Integer[]} nums
# @return {Integer}
def longest_consecutive(nums)
        map={}
        max=0
        for i in nums
                if map[i]!=nil
                        next
                end
		
		left= map[i-1]!=nil ? map[i-1] : 0
		right= map[i+1]!=nil ? map[i+1] :0

                len=left+1+right
		max=len>max ? len : max
		map[i]=len
		map[i-left]=len
		map[i+right]=len
			
                #puts "#{map} \n"
                end
        return max
end

nums=[0,3,7,2,5,8,4,6,0,1]
puts longest_consecutive nums
