#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        sort(nums.begin(), nums.end());
        int ans = 1, last = nums[0] + 1, cur = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] == last) {
                cur++;
                last++;
            } else if (nums[i] == last - 1) {
                continue;
            } else {
                last = nums[i] + 1;
                ans = max(ans, cur);
                cur = 1;
            }
        }
        ans = max(ans, cur);
        return ans;
    }
};

int main() {

    vector<int> nums = {9,1,4,7,3,-1,0,5,8,-1,6};
    Solution solution;
    cout << solution.longestConsecutive(nums) << endl;

    return 0;
}