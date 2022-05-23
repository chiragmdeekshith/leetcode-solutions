package medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int left = height[i];
            int right = height[j];
            int area = Math.min(left, right) * (j - i);
            max = Math.max(max, area);
            if(left <= right){
                while (height[i] <= left && i<j){
                    i++;
                }
            }
            else if( left > right){
                while (height[j] <= right && i<j){
                    j--;
                }
            }
        }
        return max;
    }
}
