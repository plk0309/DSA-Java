import java.util.*;

class Codechef {
    static final int MOD = 998244353;
    static final int ROOT = 3;

    static long power(long a, long b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1)
                res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static void ntt(int[] a, boolean invert) {
        int n = a.length;

        for (int i = 1, j = 0; i < n; i++) {
            int bit = n >> 1;
            while ((j & bit) != 0) {
                j ^= bit;
                bit >>= 1;
            }
            j ^= bit;

            if (i < j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        for (int len = 2; len <= n; len <<= 1) {
            long wlen = power(ROOT, (MOD - 1) / len);

            if (invert)
                wlen = power(wlen, MOD - 2);

            for (int i = 0; i < n; i += len) {
                long w = 1;

                for (int j = 0; j < len / 2; j++) {
                    int u = a[i + j];
                    int v = (int)(a[i + j + len / 2] * w % MOD);

                    a[i + j] = (int)((u + (long)v) % MOD);
                    a[i + j + len / 2] =
                        (int)((u - (long)v + MOD) % MOD);

                    w = w * wlen % MOD;
                }
            }
        }

        if (invert) {
            long inv = power(n, MOD - 2);

            for (int i = 0; i < n; i++)
                a[i] = (int)(a[i] * inv % MOD);
        }
    }

    static int[] multiply(int[] a, int[] b) {
        if (a.length < b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        if (b.length == 1) {
            int[] res = new int[a.length];
            for (int i = 0; i < a.length; i++)
                res[i] = (int)((long)a[i] * b[0] % MOD);
            return res;
        }

        if ((long)a.length * b.length <= 4096) {
            int[] res = new int[a.length + b.length - 1];

            for (int i = 0; i < a.length; i++) {
                if (a[i] == 0) continue;

                for (int j = 0; j < b.length; j++) {
                    res[i + j] = (int)(
                        (res[i + j] + (long)a[i] * b[j]) % MOD
                    );
                }
            }
            return res;
        }

        int size = 1;
        int need = a.length + b.length - 1;

        while (size < need)
            size <<= 1;

        int[] fa = Arrays.copyOf(a, size);
        int[] fb = Arrays.copyOf(b, size);

        ntt(fa, false);
        ntt(fb, false);

        for (int i = 0; i < size; i++)
            fa[i] = (int)((long)fa[i] * fb[i] % MOD);

        ntt(fa, true);

        return Arrays.copyOf(fa, need);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();

            int[] blocks = new int[N];
            int count = 0;
            int max = 0;

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();

                if (x > max) {
                    max = x;
                    blocks[count++] = 1;
                } else {
                    blocks[count - 1]++;
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a.length)
            );

            for (int i = 0; i < count; i++) {
                int len = blocks[i];

                int[] poly = new int[len + 1];
                poly[0] = 1;
                poly[len] = 1;

                pq.add(poly);
            }

            while (pq.size() > 1) {
                int[] a = pq.poll();
                int[] b = pq.poll();

                pq.add(multiply(a, b));
            }

            int[] ans = pq.poll();

            for (int i = 0; i <= N; i++) {
                sb.append(ans[i]);
                sb.append(i == N ? '\n' : ' ');
            }
        }

        System.out.print(sb);
        sc.close();
    }
}