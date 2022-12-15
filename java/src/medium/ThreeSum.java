package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int sum;
        List<Integer> templist;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    templist = new ArrayList<>();
                    templist.add(nums[i]);
                    templist.add(nums[left]);
                    templist.add(nums[right]);
                    result.add(templist);
                    left++;
                    right--;
                    while (nums[left] == nums[left-1] && left<right){
                        left++;
                    }
                    while (nums[right] == nums[right+1] && left<right){
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
