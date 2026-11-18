# HALFPIE

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Half-Price Pie

Chef runs a bakery. Every day for the next $N$ days, he bakes exactly one salted caramel pie and sells it.
The price of the pie on day $i$ is $A_i$. All prices are  **even**.

Chef will run a discount on  **exactly two consecutive**  days: on those two days, the price of the pie is halved.

Find the maximum total amount Chef can earn over the $N$ days, if he chooses the two days to halve price appropriately.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains a single integer $N$, the number of days. The second line contains $N$ space-separated integers $A_1, A_2, \ldots, A_N$, denoting the prices of the pie.
### Output Format

For each test case, output on a new line the maximum total amount Chef can earn.

### Constraints
- $1 \leq T \leq 100$
- $2 \leq N \leq 100$
- $2 \leq A_i \leq 100$
- Each $A_i$ is even.
### Sample 1:
Input
Output

```
4
2
10 6
6
12 4 4 30 2 50
5
2 4 10 8 6
4
10 8 6 2

```

```
8
98
27
22

```

### Explanation:

 **Test case $1$:**  There are only two days, so Chef must discount the pie on both days. His earnings will equal $5 + 3 = 8$.

 **Test case $2$:**  Discounting days $2$ and $3$ (prices $4$ and $4$) gives $12 + 2 + 2 + 30 + 2 + 50 = 98$.

 **Test case $4$:**  Discounting the last two days gives $10 + 8 + 3 + 1 = 22$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-18T14:47:42.092Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int [] a=new int[n];
		    int sum=0;
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        sum+=a[i];
		    }
		    int min=a[0]+a[1];
		    for(int i=1;i<n-1;i++){
		        int pair=a[i]+a[i+1];
		        if(pair<min){
		            min=pair;
		        }
		    }
		    int answer=sum-min/2;
		    System.out.println(answer);
		}

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/HALFPIE)