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
            // 将其抽象成链表中是否存在环的问题，借用快慢指针来实现
            int fast = 0;
            int slow = 0;
            while (true) {
                fast = nums[nums[fast]];
                slow = nums[slow];
                // 两者相遇
                if (slow == fast) {
                    // 一个从头开始，一个从相遇点一步步走，两者相遇的地方就是环的入口
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