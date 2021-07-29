package leetcode.editor.cn;

//Java：寻找重复数
public class P287FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new P287FindTheDuplicateNumber().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            int fast = 0;
            int slow = 0;
            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                if (slow == fast) {
                    fast = 0;
                    while (nums[slow] != nums[fast]) {
                        fast = nums[fast];
                        slow = nums[slow];
                    }
                    return nums[slow];
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}