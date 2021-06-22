//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该账户的邮箱地址。 
//
// 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 
//
// 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按字符 ASCII 顺序排列的邮箱地址。账户本身可以以任意顺序返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//输出：
//[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  
//["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//解释：
//第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
//第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
//可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
//['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的
//。
// 
//
// 
//
// 提示： 
//
// 
// accounts的长度将在[1，1000]的范围内。 
// accounts[i]的长度将在[1，10]的范围内。 
// accounts[i][j]的长度将在[1，30]的范围内。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 271 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：账户合并
public class P721AccountsMerge {
    public static void main(String[] args) {
        Solution solution = new P721AccountsMerge().new Solution();
        // TO TEST
        System.out.println(solution.accountsMerge(new ArrayList<List<String>>() {{
            add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
            add(Arrays.asList("John", "johnnybravo@mail.com"));
            add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
            add(Arrays.asList("Mary", "mary@mail.com"));
        }}));
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
            if (parent[p] != p) {
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
    }

    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            // 账户合并
            int n = accounts.size();
            List<List<String>> res = new ArrayList<>();
            UnionFind uf = new UnionFind(n);
            Map<String, Integer> emailIdMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                List<String> account = accounts.get(i);
                for (int j = 1; j < account.size(); j++) {
                    String email = account.get(j);
                    Integer otherId = emailIdMap.get(email);
                    if (otherId == null) {
                        // map中没有相关信息
                        emailIdMap.put(email, i);
                    } else {
                        // 用行号区分不同的记录
                        uf.union(i, otherId);
                    }
                }
            }
            // 将行号和emails对应起来
            Map<Integer, List<String>> idEmailsMap = new HashMap<>();
            for (Map.Entry<String, Integer> emailId : emailIdMap.entrySet()) {
                String email = emailId.getKey();
                int id = emailId.getValue();
                int rootId = uf.find(id);
                idEmailsMap.computeIfAbsent(rootId, ArrayList::new).add(email);
            }
            // 组装最终的结果
            for (Map.Entry<Integer, List<String>> idEmails : idEmailsMap.entrySet()) {
                int id = idEmails.getKey();
                List<String> emails = idEmails.getValue();
                Collections.sort(emails);
                List<String> oneLine = new ArrayList<>();
                String name = accounts.get(id).get(0);
                oneLine.add(name);
                oneLine.addAll(emails);
                res.add(oneLine);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}