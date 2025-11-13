#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.length() <= 0) return 0;
        map<char, vector<int>> pos;
        for (int i = 0; i < s.length(); i++) {
            pos[s[i] - 'a'].push_back(i);
        }
        int ans = 0, tmp = 0;
        for (int i = 0; i < s.length(); i++) {
            if (pos[s[i] - 'a'].size() > 1) {
                int location = lower_bound(pos[s[i] - 'a'].begin(), pos[s[i] - 'a'].end(), i) - pos[s[i] - 'a'].begin() - 1;
                if (location >= 0) {
                    if (tmp >= i - pos[s[i] - 'a'][location]) {
                        tmp = i - pos[s[i] - 'a'][location];
                        ans = max(ans, tmp);
                    } else {
                        tmp++;
                        ans = max(ans, tmp);
                    }
                } else {
                    tmp++;
                    ans = max(ans, tmp);
                }
            } else {
                tmp++;
                ans = max(ans, tmp);
            }
        }    
        ans = max(ans, tmp);
        return ans;
    }
};

int main() {

    Solution solution;
    string s = "cdd";
    cout << solution.lengthOfLongestSubstring(s) << endl;

    return 0;
}
/*



abcabcabc
0123 tmp = 3



*/