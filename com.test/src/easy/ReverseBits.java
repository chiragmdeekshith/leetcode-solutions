package easy;

public class ReverseBits {
    public int reverseBits(int n) {
        int bit;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            bit = (n >> i) & 1;
            result |= bit << (31 - i);
        }
        return result;
    }
}
