# SQUASH

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Squash

You are given a string $S$ of length $N$ consisting only of the characters `A` and `B`, and an integer $K$.

In one operation, you may choose two adjacent  **equal**  characters of $S$ and delete exactly one of them.

Determine whether it is possible to obtain a string of length exactly $K$ after performing zero or more operations.

### Input Format
- The first line of input will contain a single integer $T$, denoting the number of test cases.
- Each test case consists of two lines of input. The first line of each test case contains two space-separated integers $N$ and $K$. The second line contains the string $S$.
### Output Format

For each test case, output on a new line `YES` if a string of length $K$ can be obtained, and `NO` otherwise.

Each letter of `YES` and `NO` may be printed in either uppercase or lowercase.

### Constraints
- $1 \leq T \leq 100$
- $1 \leq K \leq N \leq 100$
- $S$ consists only of the characters A and B.
### Sample 1:
Input
Output

```
5
10 3
BBBAAAAAAB
4 3
ABAB
5 1
AAAAA
6 6
ABBAAB
9 4
ABBBAABAA

```

```
YES
NO
YES
YES
NO

```

### Explanation:

 **Test case $1$:**  `BBBAAAAAAB` can be reduced to `BAB`, which has length $3$. One valid sequence is as follows:

- Choose one of the first two characters and delete them. The string becomes BBAAAAAAB.
- Again choose one of the first two characters and delete them. The string becomes BAAAAAAB.
- Now repeatedly choose two adjacent A's and delete one of them. The string will eventually become BAB.

 **Test case 2:**  No two adjacent characters of `ABAB` are equal, so no operation can be performed and the length stays $4$.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-18T14:59:16.822Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int k=sc.nextInt();
		    String s=sc.next();
		    int count=1;
		    for(int i=1;i<n;i++){
		        if(s.charAt(i)!=s.charAt(i-1)){
		            count++;
		            
		        }
		    }
		    if(count<=k)
		    {
		        System.out.println("YES");
		        
		    }
		    else{
		        System.out.println("NO");
		    }
		}

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/SQUASH)