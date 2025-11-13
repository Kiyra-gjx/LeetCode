#include <bits/stdc++.h>
using namespace std;
using ll = long long;

class Solution {
public:
    bool canJump(vector<int>& nums) {
        // int idEnd = nums.size() - 1;
        int need = 1;
        bool found = 1;
        for (int i = nums.size() - 2; i > 0; i--) {
            if (nums[i] >= need) {
                need = 1;
            } else {
                found = 0;
                need++;
            }
        }
        return found;
    }
};