//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。 
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 800 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：课程表
public class P207CourseSchedule {
    public static void main(String[] args) {
        Solution solution = new P207CourseSchedule().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 拓扑排序
            int n = prerequisites.length;
            if (n == 0) {
                // 没有约束返回true
                return true;
            }
            int[] inDegrees = new int[numCourses];
            Map<Integer, List<Integer>> graph = new HashMap<>();
            for (int i = 0; i < numCourses; i++) {
                graph.put(i, new ArrayList<>());
            }
            for (int[] prerequisite : prerequisites) {
                int course = prerequisite[0];
                int preCourse = prerequisite[1];
                inDegrees[course]++;
                graph.get(preCourse).add(course);
            }
            int[] flags = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (dfs(graph, i, flags)) {
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(Map<Integer, List<Integer>> graph, int course, int[] flags) {
            if (flags[course] == 1) {
                return true;
            }
            if (flags[course] == -1) {
                return false;
            }
            flags[course] = 1;
            for (Integer nextCourse : graph.get(course)) {
                if (dfs(graph, nextCourse, flags)) {
                    return true;
                }
            }
            flags[course] = -1;
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}