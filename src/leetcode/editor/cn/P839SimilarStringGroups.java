//如果交换字符串 X 中的两个不同位置的字母，使得它和字符串 Y 相等，那么称 X 和 Y 两个字符串相似。如果这两个字符串本身是相等的，那它们也是相似的。 
//
//
// 例如，"tars" 和 "rats" 是相似的 (交换 0 与 2 的位置)； "rats" 和 "arts" 也是相似的，但是 "star" 不与 "t
//ars"，"rats"，或 "arts" 相似。 
//
// 总之，它们通过相似性形成了两个关联组：{"tars", "rats", "arts"} 和 {"star"}。注意，"tars" 和 "arts" 是在同
//一组中，即使它们并不相似。形式上，对每个组而言，要确定一个单词在组中，只需要这个词和该组中至少一个单词相似。 
//
// 给你一个字符串列表 strs。列表中的每个字符串都是 strs 中其它所有字符串的一个字母异位词。请问 strs 中有多少个相似字符串组？ 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["tars","rats","arts","star"]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：strs = ["omv","ovm"]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 300 
// 1 <= strs[i].length <= 300 
// strs[i] 只包含小写字母。 
// strs 中的所有单词都具有相同的长度，且是彼此的字母异位词。 
// 
//
// 
//
// 备注： 
//
// 字母异位词（anagram），一种把某个字符串的字母的位置（顺序）加以改换所形成的新词。 
// Related Topics 深度优先搜索 并查集 图 
// 👍 122 👎 0


package leetcode.editor.cn;

//Java：相似字符串组
public class P839SimilarStringGroups {
    public static void main(String[] args) {
        Solution solution = new P839SimilarStringGroups().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            if (p != parent[p]) {
                parent[p] = find(parent[p]);
            }
            return parent[p];
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                parent[rootP] = rootQ;
            }
        }

        public int getSetNum() {
            int cnt = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

    class Solution {
        public int numSimilarGroups(String[] strs) {
            int n = strs.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isSimilar(strs[i], strs[j])) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.getSetNum();
        }

        private boolean isSimilar(String str1, String str2) {
            int cnt = 0;
            int n = str1.length();
            // 因为本身str1和str2就是异位词，所以相似的话只需要它们有两个位置不同即可，注意两个字符串完全相同也是相似的
            for (int i = 0; i < n; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    cnt++;
                }
            }
            return cnt <= 2;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}