//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 548 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：复原 IP 地址
public class P93RestoreIpAddresses {
    public static void main(String[] args) {
        Solution solution = new P93RestoreIpAddresses().new Solution();
        // TO TEST
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> resList = new ArrayList<>();
            if (s.length() < 4 || s.length() > 12) {
                return resList;
            }
            List<String> list = new ArrayList<>();
            dfs(s, 0, 0, list, resList);
            return resList;
        }

        private void dfs(String s, int pos, int splitTimes, List<String> list, List<String> resList) {
            int remainStrLen = s.length() - pos;
            int remainSplitTimes = 4 - splitTimes;
            if (remainStrLen < remainSplitTimes || remainStrLen > 3 * remainSplitTimes) {
                // 剩下的数字不够划分或者太多了划分不过来都要提前剪枝（每一段数字数是1-3）
                return;
            }
            if (list.size() == 4) {
                // 划分完成
                resList.add(String.join(".", list));
                return;
            }
            // 划分
            for (int i = pos; i < pos + 3 && i < s.length(); i++) {
                String segment = s.substring(pos, i + 1);
                if (isValidIpSegment(segment)) {
                    list.add(segment);
                    dfs(s, i + 1, splitTimes + 1, list, resList);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean isValidIpSegment(String segment) {
            if (!segment.equals("0") && segment.charAt(0) == '0') {
                return false;
            }
            int num = Integer.parseInt(segment);
            return num <= 255;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}