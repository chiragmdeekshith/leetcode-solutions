package easy;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slowpointer = n;
        int fastpointer = findSquareOfDigits(n);
        while (slowpointer != fastpointer) {
            slowpointer = findSquareOfDigits(slowpointer);
            fastpointer = findSquareOfDigits(findSquareOfDigits(fastpointer));
        }
        return slowpointer == 1;
    }

    private int findSquareOfDigits(int n) {
        int sum = 0;
        int digit;
        while (n > 0) {
            digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
