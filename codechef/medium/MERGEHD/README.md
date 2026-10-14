# MERGEHD

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Merging (Hard)

Define $merge(A, B)$ as the array $C$ formed by the following process:

- Initialize $i = 0, j = 0, C = []$ (empty array)
- While both $i < |A|, j < |B|$ holds, do the following: if $A_i < B_j$, append $A_i$ to $C$ and increment $i$ by $1$. Else, append $B_j$ to $C$ and increment $j$ by $1$.
- While $i < |A|$, append $A_i$ to $C$ and increment $i$ by $1$.
- While $j < |B|$, append $B_j$ to $C$ and increment $j$ by $1$.

For example, it can be shown that $merge([2, 3], [1, 4]) = [1, 2, 3, 4]$, and $merge([3, 2], [4, 1]) = [3, 2, 4, 1]$.

You are given a permutation $P$ of the integers $[1, N].$

For each $i = 0, 1, 2, \ldots, N$, count how many pairs of arrays $A$ and $B$ exist such that $merge(A, B) = P$ and $|A| = i$. Since the answers may be large, output them modulo $998244353$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line contains a single integer $N$. The second line contains $N$ integers - $P_1, P_2, \ldots, P_N$.
### Output Format

For each test case, output on a new line $N + 1$ integers - the number of pairs of arrays $A$ and $B$ such that $|A| = i$ for each $i = 0, 1, \ldots, N$ modulo $998244353$.

### Constraints
- $1 \le T \le 10^4$
- $1 \le N \le 2 \cdot 10^5$
- $1 \le P_i \le N$
- $P_i \ne P_j$ for all $i \ne j$
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
4
4
1 2 3 4
4
3 2 4 1
1
1
7
2 4 3 6 5 1 7

```

```
1 4 6 4 1
1 0 2 0 1
1 1
1 2 2 3 3 2 2 1
```

### Explanation:

 **Test Case 1:**  Every sorted subset of $P$ works as $A$, and its complement as $B$. This is because the merge (as defined) of $2$ sorted arrays will always be sorted.

 **Test Case 2:**  The possibilities are:

- $A = [], B = [3, 2, 4, 1]$
- $A = [3, 2], B = [4, 1]$
- $A = [4, 1], B = [3, 2]$
- $A = [3, 2, 4, 1], B = []$

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-14T15:33:21.672Z  

```java
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
```

---

[View on CodeChef](https://www.codechef.com/problems/MERGEHD)