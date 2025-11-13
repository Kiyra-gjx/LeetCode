#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        vector<int> pre(nums.size() + 1);
        unordered_map<int, int> mp;
        mp[0] = 1;
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            pre[i + 1] = pre[i] + nums[i];
            if (mp[pre[i + 1] - k]) ans += mp[pre[i + 1] - k];
            mp[pre[i + 1]]++;
        }
        return ans;
    }
};

int main() {

    vector<int> nums = {1};
    Solution solution;
    cout << solution.subarraySum(nums, 0) << endl;

    return 0;
}