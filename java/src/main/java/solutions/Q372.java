package solutions;

public class Q372 extends Solution {

    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        int ans = 1;
        for (int i = b.length - 1; i >= 0; --i) {
            ans = ans * pow(a, b[i]) % MOD;
            a = pow(a, 10);
        }
        return ans;
    }

    private int pow(int a, int b) {
        int ans = 1;
        a %= MOD;
        while (b != 0) {
            if (b % 2 == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>>= 1;
        }
        return ans;
    }

}
