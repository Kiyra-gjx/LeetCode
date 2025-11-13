#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [&] (vector<int> a, vector<int> b) {
            if (a[0] == b[0]) return a[1] < b[1];
            return a[0] < b[0];
        });
        vector<vector<int>> ans; 
        vector<int> tmp;
        for (auto x : intervals) {
            if (!tmp.size()) {
                tmp = intervals[0];
                continue;
            }
            if (tmp.back() < x.front()) {
                ans.push_back(tmp);
                tmp = x;
            } else {
                if (tmp.back() >= x.back()) {
                    continue;
                } else {
                    tmp.back() = x.back();
                }
            }
        }
        ans.push_back(tmp);
        return ans;
    }
};

int main() {

    Solution solution;
    vector<vector<int>> intervals = {{1,3},{2,6},{8,10},{15,18}};
    vector<vector<int>> tmp = solution.merge(intervals);
    for (auto x : tmp) {
        for (auto y : x) {
            cout << y << ' ';
        }
        cout << endl;
    }

    return 0;
}