package interviewClassic;

import java.util.HashSet;

// class Solution {
class Solution26 {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int ptr = 0;
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                nums[ptr++] = i;
            }
        }
        return ptr;
    }
}

public class t26 {
}
