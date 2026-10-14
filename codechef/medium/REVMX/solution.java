import java.util.*;

class Codechef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int[] P = new int[N + 1];
            int[] prefix = new int[N + 1];
            long[] arr = new long[N];

            int fixed = 0;
            long base = N + 1L;

            for (int i = 1; i <= N; i++) {
                P[i] = sc.nextInt();

                if (P[i] == i) {
                    fixed++;
                }

                prefix[i] = fixed;

                int sum = i + P[i];
                int left = Math.min(i, P[i]);

                arr[i - 1] = sum * base + (N - left);
            }

            Arrays.sort(arr);

            int ans = fixed;
            int prevSum = -1;
            int count = 0;

            for (long value : arr) {
                int sum = (int)(value / base);
                int left = N - (int)(value % base);
                int right = sum - left;

                if (sum != prevSum) {
                    count = 0;
                    prevSum = sum;
                }

                count++;

                int lost = prefix[right] - prefix[left - 1];
                int gain = count - lost;

                ans = Math.max(ans, fixed + gain);
            }

            System.out.println(ans);
        }
        sc.close();
    }
}