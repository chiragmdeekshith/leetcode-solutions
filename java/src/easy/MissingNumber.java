package easy;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += i + 1 - nums[i];
        }
        return result;
    }

    public int missingNumberBinary(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= (i + 1) ^ nums[i];
        }
        return result;
    }
}
