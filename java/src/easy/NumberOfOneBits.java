package easy;

public class NumberOfOneBits {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeightSlow(int n) {
        int result = 0;
        while (n != 0) {
            result += n % 2;
            n /= 2;
        }
        return result;
    }

    public int hammingWeightMedium(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 2;
            n >>= 1;
        }
        return result;
    }

    public int hammingWeightFast(int n) {
        int result = 0;
        while (n > 0) {
            n &= n - 1;
            result++;
        }
        return result;
    }
}
