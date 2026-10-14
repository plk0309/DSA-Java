import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		while(T-->0){
		    int N=sc.nextInt();
		    int K=sc.nextInt();
		    int[] A = new int[N];

            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            Arrays.sort(A);

            int ans = 0;
            int count = Math.min(N, K + 1);

            for (int i = N - 1; i >= N - count; i--) {
                ans += A[i];
            }

            System.out.println(ans);
		}

	}
}
