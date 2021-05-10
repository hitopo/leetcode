//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1482 👎 0


package leetcode.editor.cn;

//Java：最长公共前缀
public class P14LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new P14LongestCommonPrefix().new Solution();
        // TO TEST
        System.out.println(solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            String prefix = "";
            for (int i = 1; i <= strs[0].length(); i++) {
                String tmpPrefix = strs[0].substring(0, i);
                boolean isOk = true;
                for (int j = 1; j < strs.length; j++) {
                    if (!strs[j].startsWith(tmpPrefix)) {
                        isOk = false;
                        break;
                    }
                }
                if (!isOk) {
                    break;
                }
                prefix = tmpPrefix;
            }
            return prefix;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}