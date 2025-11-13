#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> debt(128, 0);
        int less_c_count = 0;
        for(auto &c: t)
        {
            if(debt[c] == 0)
                ++less_c_count;
            ++debt[c];
        }
        int left = 0;
        int current_length = 1;
        int min_length = INT_MAX;
        int min_left = -1;
        for(int right = 0; right < s.size(); ++right)
        {
            --debt[s[right]];
            if(debt[s[right]] == 0)
                --less_c_count;
            ++current_length;
            while(less_c_count == 0)
            {
                int current_length = right - left + 1;
                if(current_length < min_length)
                {
                    min_length = current_length;
                    min_left = left;
                }
                if(debt[s[left]] == 0)
                    ++less_c_count;
                ++debt[s[left]];
                ++left;
                --current_length;
            }
        }
        return min_left == -1 ? "" : s.substr(min_left, min_length);
    }


};

int main() {

    Solution Solution;
    string s = "ADOBECODEBANC", t = "ABC";
    cout << Solution.minWindow(s, t) << endl;

    return 0;
}