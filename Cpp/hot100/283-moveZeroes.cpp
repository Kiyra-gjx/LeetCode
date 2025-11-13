#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int p2 = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) {
                if (p2 == -1) {
                    p2 = i + 1;
                    while(p2 < nums.size() && nums[p2] == 0) {
                        p2++;
                    }
                    if (p2 == nums.size()) break;
                    else swap(nums[i], nums[p2]);
                } else {
                    while(p2 < nums.size() && nums[p2] == 0) {
                        p2++;
                    }
                    if (p2 == nums.size()) break;
                    else swap(nums[i], nums[p2]);
                }
            }
        }
    }
};

int main() {

    

    return 0;
}