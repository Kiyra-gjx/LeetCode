#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int INF32 = 0x3f3f3f3f;
const ll INF64 = 0x3f3f3f3f3f3f3f3f;

class Solution {
public:
    int jump(vector<int>& nums) {
        int start = 0, end = 0;
        int step = 0;
        while(end < nums.size() - 1) {
            int farthest = 0;
            for (int i = start; i <= end; i++) {
                farthest = max(i + nums[i], farthest);
            }
            start = end;
            end = farthest;
            step++;
        }
        return step;
    }
};

void test() {
    Solution solution;
    vector<int> nums = {2, 3, 1, 1, 4};
    cout << solution.jump(nums) << endl;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    test();

    return 0;
}