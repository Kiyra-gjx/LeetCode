#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        int slen = s.length(), plen = p.length();
        if (slen < plen) return vector<int> ();
        int count[26] {};
        for (int i = 0; i < plen; i++) {
            count[s[i] - 'a']++;
            count[p[i] - 'a']--;
        }
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i]) diff++;
        }
        vector<int> ans;
        if (diff == 0) ans.push_back(0);
        for (int i = 0; i < slen - plen; i++) {
            if (count[s[i] - 'a'] == 1) {
                diff--;
            } else if (count[s[i] - 'a'] == 0) {
                diff++;
            }
            count[s[i] - 'a']--;
            if (count[s[i + plen] - 'a'] == -1) {
                diff--;
            } else if (count[s[i + plen] - 'a'] == 0) {
                diff++;
            }
            count[s[i + plen] - 'a']++;
            if (diff == 0) ans.push_back(i + 1);
        }
        return ans;
    }
};

int main() {

    Solution solution;
    string s = "cbaebabacd", p = "abc";
    vector<int> ans = solution.findAnagrams(s, p);
    for (auto c : ans) cout << c << ' ';

    return 0;
}