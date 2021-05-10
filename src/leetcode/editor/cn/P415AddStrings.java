//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 316 👎 0


package leetcode.editor.cn;

//Java：字符串相加
public class P415AddStrings {
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        // TO TEST
        System.out.println(solution.addStrings("9", "99"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addStrings(String num1, String num2) {
            // 显然应该从后面往前面加
            StringBuilder sb = new StringBuilder();
            int i = num1.length() - 1;
            int j = num2.length() - 1;
            int carry = 0;
            while (i >= 0 || j >= 0 || carry > 0) {
                int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int sum = val1 + val2 + carry;
                int num = sum % 10;
                carry = sum / 10;
                sb.append(num);
                j--;
                i--;
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}