# MERGEEZ

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Merging (Easy)

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
- $1 \le T \le 100$
- $1 \le N \le 5000$
- $1 \le P_i \le N$
- $P_i \ne P_j$ for all $i \ne j$
- The sum of $N$ over all test cases does not exceed $5000$.
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
**Submitted:** 2026-10-14T15:24:40.054Z  

```java
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
```

---

[View on CodeChef](https://www.codechef.com/problems/MERGEEZ)