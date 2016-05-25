#!/usr/bin/env ruby
# Definition for singly-linked list.

class ListNode

     attr_accessor :val, :next

     def initialize(val)

         @val = val

         @next = nil

     end

 end



# @param {ListNode} l1

# @param {ListNode} l2

# @return {ListNode}

def add_two_numbers(l1, l2)
	of=0
	pt=ListNode.new(nil)
	head=pt
	while l1!=nil || l2!=nil
		a=0
		b=0
		if l1!=nil 
		  a=l1.val
		end
		if l2!=nil 
			 b=l2.val
		end
		sum=a+b+of
		#print "sum=#{sum}, of=#{of} \n"
		if sum<10
			pt.next=ListNode.new(sum)
			of=0
			print sum
		else
			pt.next=ListNode.new(sum-10)
			of=1
			print sum-10
		end

		if l1!=nil then l1=l1.next end
		if l2!=nil then l2=l2.next end
		pt=pt.next		
	end
	if of==1 then pt.next=ListNode.new(1) end	
  	return head.next  
end


l1=ListNode.new(2)
l1.next=ListNode.new(4)
l1.next.next=ListNode.new(3)
l2=ListNode.new(5)
l2.next=ListNode.new(6)
l2.next.next=ListNode.new(4)
print add_two_numbers(l1,l2)

