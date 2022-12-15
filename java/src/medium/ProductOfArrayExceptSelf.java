package medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf_O_n_Space(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int[] result2 = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = 1;
            postfix[i] = 1;
            result2[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
            result2[i + 1] = result2[i] * nums[i];
        }
        int mul = 1;
        for (int i = n - 1; i > 0; i--) {
            postfix[i - 1] = postfix[i] * nums[i];
            result2[i - 1] *= nums[i] * mul;
            mul *= nums[i];
        }
        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * postfix[i];
        }
        return result2;
    }

    public int[] productExceptSelf_dirty(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            result[i + 1] = result[i] * nums[i];
        }
        int mul = 1;
        for (int i = n - 1; i > 0; i--) {
            result[i - 1] *= nums[i] * mul;
            mul *= nums[i];
        }
        return result;
    }

    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];
        Arrays.fill(result, 1);
        int multiplier = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= multiplier;
            multiplier *= nums[i];
        }
        multiplier = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= multiplier;
            multiplier *= nums[i];
        }
        return result;
    }
}
