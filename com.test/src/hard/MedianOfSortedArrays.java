package hard;

public class MedianOfSortedArrays {
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sumLen = nums1.length + nums2.length;
        int[] nums3 = new int[sumLen];
        for (int i = 0, j = 0, k = 0; ; k++) {
            if (i >= nums1.length && j >= nums2.length) {
                break;
            } else if (i >= nums1.length) {
                nums3[k] = nums2[j++];
            } else if (j >= nums2.length) {
                nums3[k] = nums1[i++];
            } else if (nums1[i] < nums2[j]) {
                nums3[k] = nums1[i++];
            } else {
                nums3[k] = nums2[j++];
            }
        }
        double result = 0d;
        if (sumLen % 2 == 0) {
            int index = sumLen / 2;
            result = nums3[index] - nums3[index - 1];
            result /= 2;
            result += nums3[index - 1];
        } else {
            result = nums3[sumLen / 2];
        }
        return result;
    }
}
