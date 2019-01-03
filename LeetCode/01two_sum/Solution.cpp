#include <unordered_map>
#include <vector>

using std::vector;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
	vector<int> solution(2,0);
	for (int i=0; i<nums.size(); i++) {
	    for (int j=i; j<nums.size(); j++) {
		if (target - nums[i] == nums[j]) {
		    solution={i, j};
		}
	    }
	}
	return solution;
    }
};

#include <iostream> 

int main() {
    Solution* s = new Solution();
    vector<int> nums = {2, 7, 11, 15};
    auto rst = s->twoSum(nums, 9);
    for (auto i:rst) {
	std::cout << i << "";
    }
    std::cout << "\n";
}

