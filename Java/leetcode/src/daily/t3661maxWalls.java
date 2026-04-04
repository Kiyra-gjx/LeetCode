package daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class t3661maxWalls {
    public static void main(String[] args) {
        int[] robots = new int[] {17,59,32,11,72,18};
        int[] distance = new int[] {5,7,6,5,2,10};
        int[] walls = new int[] {17,25,33,29,54,53,18,35,39,37,20,14,34,13,16,58,22,51,56,27,10,15,12,23,45,43,21,2,42,7,32,40,8,9,1,5,55,30,38,4,3,31,36,41,57,28,11,49,26,19,50,52,6,47,46,44,24,48};
        t3661Solution solution = new t3661Solution();
        System.out.println(solution.maxWalls(robots, distance, walls));
    }
}

class t3661Solution {
    static class Robot {
        int place;
        int distance;

        Robot() {};
        Robot(int place, int distance) {
            this.place = place;
            this.distance = distance;
        };
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length, m = walls.length;
        int[][] dp = new int[n][2];

        List<Robot> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Robot(robots[i], distance[i]));
        }

        arr.sort((a, b) -> a.place - b.place);
        Arrays.sort(walls);

        int l = -1, r = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int place = arr.get(i).place;
            int dis = arr.get(i).distance;

            if (i == 0) {
                l = place - dis;
            } else {
                if (place - dis <= r) {
                    l = r + 1;
                } else {
                    l = Math.max(place - dis, arr.get(i-1).place + 1);
                }
            }
            if (i == n - 1) {
                r = place + dis;
            } else {
                r = Math.min(place + dis, arr.get(i + 1).place - 1);
            }

            if (i == 0) {
                dp[i][0] = countWalls(walls, l, place);
                dp[i][1] = countWalls(walls, place, r);
            } else {
                int left = dp[i - 1][0] + countWalls(walls, place - dis <= arr.get(i - 1).place ? arr.get(i - 1).place + 1 : place - dis, place);
                int right = dp[i - 1][1] + countWalls(walls, l, place);
                dp[i][0] = Math.max(left, right);
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + countWalls(walls, place, r);
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    private int countWalls(int[] walls, int l, int r) {
        int leftIdx = lowerBound(walls, l);   // 第一个 >= l 的位置
        int rightIdx = upperBound(walls, r);  // 第一个 > r 的位置
        return rightIdx - leftIdx;
    }

    private int lowerBound(int[] arr, int target) {
        int L = 0, R = arr.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] >= target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    private int upperBound(int[] arr, int target) {
        int L = 0, R = arr.length;
        while (L < R) {
            int mid = L + (R - L) / 2;
            if (arr[mid] > target) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }
}

/*
  11     17      18      32      59     72
[6,16] [12,23] [12,28] [29,38] [52,66] [70,74]
6 6
12 7
13 23
27 30
37 37


 */
