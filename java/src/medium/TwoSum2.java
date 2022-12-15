package medium;

public class TwoSum2 {
    public int[] twoSumSlow(int[] nums, int target) {

        int i = 0;
        int j = 1;
        while (i < j && j < nums.length) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i + 1, j + 1};
            }
            if (nums[i] + nums[j] < target) {
                i++;
                j++;
            } else if (nums[i] + nums[j] > target) {
                i--;
            }
        }
        return new int[]{};
    }

    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            if (nums[i] + nums[j] == target) {
                return new int[]{i + 1, j + 1};
            }
            if (nums[i] + nums[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}
