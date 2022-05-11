package easy;

public class BestTimeForStock {
    public static void main(String[] args) {
        new BestTimeForStock().maxProfit(new int[] {7,1,5,3,6,4});
    }
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int start = 0, end = 1; end < prices.length; end++) {
            if(prices[start] < prices[end]){
                max = Math.max(max, prices[end] - prices[start]);
            }
            else {
                start = end;
            }
        }
        return max;
    }
}
