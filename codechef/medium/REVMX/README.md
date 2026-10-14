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
**Submitted:** 2026-10-14T15:25:43.740Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/REVMX)