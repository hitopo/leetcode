package leetcode.editor.cn;

//Java：山脉数组的峰顶索引
public class P852PeakIndexInAMountainArray {
    public static void main(String[] args) {
        Solution solution = new P852PeakIndexInAMountainArray().new Solution();
        // TO TEST
        System.out.println(solution.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int peakIndexInMountainArray(int[] arr) {
            int l = 0;
            int r = arr.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] < arr[mid + 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}