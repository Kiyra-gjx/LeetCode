#include <bits/stdc++.h>
using namespace std;
using ll = long long;

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int ans = 0, nowFund = -1;
        bool beginVote = 0;
        for (int i = 0; i < prices.size(); i++) {
            if (!beginVote) {
                nowFund = -prices[i];
                beginVote = 1;
            } else {
                if (nowFund + prices[i] > 0) {
                    ans += nowFund + prices[i];
                }
                nowFund = -prices[i];
            }
        }
        return ans;
    }
};

/*


1 2 4 5
 1 2 1



7 1 5 3 6 4
   4   3 


*/