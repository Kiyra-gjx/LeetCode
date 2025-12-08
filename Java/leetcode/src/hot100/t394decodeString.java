package hot100;

public class t394decodeString {
    public static void main(String[] args) {
        t394Solution sol = new t394Solution();
        System.out.println(sol.decodeString("3[a]2[bc]"));
    }
}

class t394Solution {
    // 起始索引
    int idx = 0;

    public String decodeString(String s) {
        // 记录当前层级的答案
        StringBuilder result = new StringBuilder();

        while (idx < s.length() && s.charAt(idx) != ']') {
            if (s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                // 处理数字，解析完整的重复次数k
                int k = 0;
                while(idx < s.length() && s.charAt(idx) >= '0' && s.charAt(idx) <= '9') {
                    // 因为数字的位数可能不止一位
                    k = k * 10 + s.charAt(idx) - '0';
                    idx++;
                }

                // 此时s[idx] = '[',应该再++
                idx++;
                String curr = decodeString(s);

                // 此时s[idx] = ']',应该再++
                idx++;

                // 将字符串重复k次并添加到当前层级的结果中
                result.append(String.valueOf(curr).repeat(Math.max(0, k)));

            } else {
                result.append(s.charAt(idx));
                idx++;
            }
        }

        // 返回当前层级的答案
        return result.toString();
    }
}