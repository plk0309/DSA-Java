# CHASE7

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Chase Possible

Chef is playing a cricket match and needs to score at least $R$ more runs off the last $B$ balls to win the match.

Chef's opponent is really strong, so they won't let him get any extra runs (wides, no-balls, etc.); and hence Chef can only get at most $6$ runs from each ball.

Is it possible for Chef to still win the match? Print $\text{Yes}$ if possible, and $\text{No}$ otherwise.

### Input Format
- The first and only line of input contains $2$ integers - $R$ and $B$.
### Output Format

Output $\text{Yes}$ if Chef can still win, and $\text{No}$ otherwise.

Each letter of the output may be printed in either uppercase or lowercase, i.e. the strings $\text{no}, \text{No}, \text{nO},$ and $\text{NO}$ will all be treated as equivalent.

### Constraints
- $1 \le R \le 300$
- $1 \le B \le 120$
### Sample 1:
Input
Output

```
36 6

```

```
Yes

```

### Explanation:

Chef can still hit $6$ $6$s in the next $6$ balls to win the match.

### Sample 2:
Input
Output

```
50 8

```

```
No

```

### Explanation:

It is impossible for Chef to win.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-11-11T15:02:58.842Z  

```java
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int r=sc.nextInt();
		int b=sc.nextInt();
		if(r<=b*6){
		    System.out.println("Yes");
		}
		else{
		    System.out.println("No");
		}

	}
}

```

---

[View on CodeChef](https://www.codechef.com/problems/CHASE7)