package easy;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int currentsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (currentsum < 0) {
                currentsum = 0;
            }
            currentsum += nums[i];
            maxsum = Math.max(maxsum, currentsum);
        }
        return maxsum;
    }
}
