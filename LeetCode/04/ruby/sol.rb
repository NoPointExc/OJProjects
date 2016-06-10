# @param {Integer[]} nums1
# @param {Integer[]} nums2
# @return {Float}
def find_median_sorted_arrays(nums1, nums2)
   	len=nums1.length + nums2.length
       	p1=0
	p2=0
	half=len/2   
	mid1=nil
	mid2=nil
	while (p1+p2) <= half do
		mid2=mid1
		if nums2[p2]==nil || (nums1[p1]!=nil && nums1[p1]<=nums2[p2])
			mid1 = nums1[p1]
			p1+=1		
		else
			mid1 = nums2[p2]
			p2+=1
		end	
	end
	
	rst=mid1
	if len%2==0
		rst= (mid1+mid2) / 2.0
	end
	return rst	
end

#test
nums1=[3,8,9]
nums2=[1,2,4,5]
puts find_median_sorted_arrays nums1 , nums2 
