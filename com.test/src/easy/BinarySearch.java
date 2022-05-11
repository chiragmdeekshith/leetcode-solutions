package easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (target > nums[mid]) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
