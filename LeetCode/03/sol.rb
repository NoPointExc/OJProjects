#!/usr/bin/env ruby

# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
	dict={}
	max=0
	i=0
	from=0
	to=0
	while i < s.length
		if dict[s[i]]==nil ||dict[s[i]]<from
			to=i
		else
			from=dict[s[i]]+1
		end
		dict[s[i]]=i
		i+=1
		max=max>(to-from+1) ? max:(to-from+1)
		#print "i=#{i} chr=#{s[i]} dict=#{dict} from=#{from} to=#{to} max=#{max}\n"
			
	end
	return max	
end

print length_of_longest_substring("a")

