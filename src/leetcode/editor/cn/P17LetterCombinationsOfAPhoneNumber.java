//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1303 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：电话号码的字母组合
public class P17LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations("23"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> letterCombinations(String digits) {
            Map<Character, String> map = new HashMap<>();
            map.put('2', "abc");
            map.put('3', "def");
            map.put('4', "ghi");
            map.put('5', "jkl");
            map.put('6', "mno");
            map.put('7', "pqrs");
            map.put('8', "tuv");
            map.put('9', "wxyz");
            List<String> resList = new ArrayList<>();
            if ("".equals(digits)) {
                return resList;
            }
            combineHelper(digits, 0, new StringBuilder(), map, resList);
            return resList;
        }

        /**
         * 回溯的主要方法
         * @param digits  数字
         * @param pos     当前处理的是哪一个数字
         * @param sb      暂存的结果
         * @param map     数字和字母的对应关系
         * @param resList 结果
         */
        private void combineHelper(String digits, int pos, StringBuilder sb, Map<Character, String> map, List<String> resList) {
            // 数字都处理完了，输出结果
            if (pos == digits.length()) {
                resList.add(sb.toString());
                return;
            }
            String possibleChars = map.get(digits.charAt(pos));
            for (int i = 0; i < possibleChars.length(); i++) {
                char ch = possibleChars.charAt(i);
                sb.append(ch);
                combineHelper(digits, pos + 1, sb, map, resList);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}