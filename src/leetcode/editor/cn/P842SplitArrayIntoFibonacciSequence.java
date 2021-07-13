package leetcode.editor.cn;

import javax.jnlp.IntegrationService;
import java.util.ArrayList;
import java.util.List;

//Java：将数组拆分成斐波那契序列
public class P842SplitArrayIntoFibonacciSequence {
    public static void main(String[] args) {
        Solution solution = new P842SplitArrayIntoFibonacciSequence().new Solution();
        // TO TEST
        System.out.println(solution.splitIntoFibonacci("123456579"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private List<Integer> resList = new ArrayList<>();

        public List<Integer> splitIntoFibonacci(String num) {
            // 将数组拆分的时候显然应该使用回溯的方法
            if (num.length() < 3) {
                return resList;
            }
            dfs(num, 0, new ArrayList<>());
            return resList;
        }

        private void dfs(String num, int pos, List<Integer> list) {
            if (pos == num.length() && list.size() >= 3) {
                resList = new ArrayList<>(list);
                return;
            }
            // 尝试划分
            for (int i = pos; i < num.length(); i++) {
                String subS = num.substring(pos, i + 1);
                if (isValidNum(subS) && (list.size() < 2
                        || list.get(list.size() - 1) + list.get(list.size() - 2) == Integer.parseInt(subS))) {
                    list.add(Integer.parseInt(subS));
                    dfs(num, i + 1, list);
                    list.remove(list.size() - 1);
                }
            }

        }

        private boolean isValidNum(String s) {
            if (s.startsWith("0")) {
                return s.length() == 1;
            }
            // 也有可能划分的长度太长了，也是不行的
            return s.length() < 11 && Long.parseLong(s) < Integer.MAX_VALUE;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}