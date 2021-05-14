import java.util.Arrays;

/**
 * 给定两个正整数数组nums1和nums2，值都在[1,6]，两个数组的长度不一定相等
 * 记一次操作为改变数组任意位置的元素值，问最小的操作次数使得两个数组中的元素和相等
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(getMinOperationNum(new int[]{6, 2, 4, 3, 1, 5}, new int[]{1, 2, 1, 2, 2, 2}));
        System.out.println(getMinOperationNum(new int[]{}, new int[]{1, 1, 2}));
        System.out.println(getMinOperationNum(new int[]{1, 2}, new int[]{1, 6, 4}));
        System.out.println(getMinOperationNum(new int[]{1, 3, 2}, new int[]{}));
        System.out.println(getMinOperationNum(new int[]{1}, new int[]{6, 6, 6}));
    }

    private static int getMinOperationNum(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return -1;
        }
        int sum1 = 0;
        int sum2 = 0;
        for (int num : nums1) {
            sum1 += num;
        }
        for (int num : nums2) {
            sum2 += num;
        }
        int cnt = 0;
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int diff = Math.abs(sum1 - sum2);
        if (sum1 > sum2) {
            cnt = f(nums1, nums2, diff);
        } else if (sum2 > sum1) {
            cnt = f(nums2, nums1, diff);
        }
        return cnt;
    }

    /**
     * 调整nums1和nums2，使得两者的和相等
     * @param nums1 较大的那个数组
     * @param nums2 较小的那个数组
     * @param diff  原始差值
     * @return 操作次数
     */
    private static int f(int[] nums1, int[] nums2, int diff) {
        int cnt = 0;
        int i = nums1.length - 1;
        int j = 0;
        while (diff > 0 && i >= 0 && j < nums2.length) {
            int adjustment = Math.max(nums1[i] - 1, 6 - nums2[j]);
            diff -= adjustment;
            cnt++;
            if (nums1[i] - 1 > 6 - nums2[j]) {
                i--;
            } else {
                j++;
            }
        }
        while (diff > 0 && i >= 0) {
            diff -= (nums1[i] - 1);
            cnt++;
            i--;
        }
        while (diff > 0 && j < nums2.length) {
            diff -= (6 - nums2[j]);
            cnt++;
            j++;
        }
        return diff > 0 ? -1 : cnt;
    }
}

