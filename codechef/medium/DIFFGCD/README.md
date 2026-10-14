# DIFFGCD

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Difference is GCD

You are given an integer $N$. Count the number of pairs $(X, Y)$ such that:

- $1 \le X < Y \le N$
- $gcd(X, Y) = |X - Y|$

where $gcd(A, B)$ denotes the greatest common divisor of both $A$ and $B$.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- The first and only line of each test case contains a single integer $N$.
### Output Format

For each test case, output the number of pairs $(X, Y)$ satisfying the conditions.

### Constraints
- $1 \le T \le 100$
- $2 \le N \le 10^9$
### Sample 1:
Input
Output

```
4
2
3
4
10

```

```
1
2
4
17
```

### Explanation:

 **Test Case 1:**  $(1, 2)$ is the only pair.

 **Test Case 2:**  $(1, 2)$ and $(2, 3)$ are valid pairs.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-14T15:11:22.707Z  

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

[View on CodeChef](https://www.codechef.com/problems/DIFFGCD)