import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int MOD = 998244353;

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] blocks = new int[N];
            int count = 0, max = 0;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                if (x > max) {
                    max = x;
                    blocks[count++] = 1;
                } else {
                    blocks[count - 1]++;
                }
            }

            int[] dp = new int[N + 1];
            dp[0] = 1;
            int sum = 0;

            for (int i = 0; i < count; i++) {
                int len = blocks[i];

                for (int j = sum; j >= 0; j--) {
                    dp[j + len] = (dp[j + len] + dp[j]) % MOD;
                }

                sum += len;
            }

            for (int i = 0; i <= N; i++) {
                System.out.print(dp[i] + " ");
            }
            System.out.println();
        }
    }
}