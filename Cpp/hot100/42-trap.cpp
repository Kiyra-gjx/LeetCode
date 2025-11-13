#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int trap(vector<int>& height) {
        int n = height.size();
        vector<int> suff(n + 1);
        int cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            cur = max(cur, height[i]);
            suff[i] = cur;
        }
        cur = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (cur + height[i] == 0) continue;
            if (cur < height[i]) {
                cur = height[i];
            } else {
                ans += min(cur, suff[i]) - height[i];
            }
        }
        return ans;
    } 
};

int main() {

    vector<int> height = {0,1,0,2,1,0,1,3,2,1,2,1};
    Solution solution;
    cout << solution.trap(height) << endl;

    return 0;
}