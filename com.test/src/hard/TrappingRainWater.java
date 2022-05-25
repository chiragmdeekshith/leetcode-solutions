package hard;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null) {
            return 0;
        }
        int water = 0;
        int i = 0;
        int j = height.length - 1;
        int leftMax = height[i];
        int rightMax = height[j];

        while (i < j) {
            if (height[i] < height[j]) {
                i++;
                leftMax = Math.max(leftMax, height[i]);
                water += leftMax - height[i];
            } else {
                j--;
                rightMax = Math.max(rightMax, height[j]);
                water += rightMax - height[j];
            }
        }

        return water;
    }
}
