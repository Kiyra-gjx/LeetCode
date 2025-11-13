#include <bits/stdc++.h>
using namespace std;
using ll = long long;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> index;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            if (index.find(complement) != index.end()) {
                return {index[complement], i};
            }
            index[nums[i]] = i;
        }
        return {};
    }
};