# REVMX

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Reversal Maximize

For a permutation $P$ of the integers $[1, N]$, define $f(P)$ as the number of fixed points it has, i.e. $f(P) =$ the number of $i$ such that $P_i = i$.

You are given a permutation $P$, and you can do the following operation  **at most once** :

- Choose $1 \le L \le R \le N$, and reverse the subarray $P[L, R]$.

Maximize $f(P)$ after at most one such reversal.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of multiple lines of input. The first line contains a single integer $N$. The second line contains $N$ integers - $P_1, P_2, \ldots, P_N$.
### Output Format

For each test case, output on a new line the maximum value of $f(P)$.

### Constraints
- $1 \le T \le 10^4$
- $2 \le N \le 2 \cdot 10^5$
- $1 \le P_i \le N$
- $P_i \ne P_j$ for all $i \ne j$
- The sum of $N$ over all test cases does not exceed $2 \cdot 10^5$.
### Sample 1:
Input
Output

```
4
5
1 4 3 2 5
6
2 4 6 1 3 5
3
1 2 3
6
5 1 3 2 6 4

```

```
5
1
3
3
```

### Explanation:

 **Test Case 1:**  Reverse the subarray $[2, 4]$ to get $[1, 2, 3, 4, 5]$ which has $5$ fixed points.

 **Test Case 3:**  The original array already has $3$ fixed points, no need of any reversal.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-14T15:28:45.068Z  

```java
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
```

---

[View on CodeChef](https://www.codechef.com/problems/REVMX)