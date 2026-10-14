import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            long N = sc.nextLong();
            long ans = 0;

            for (long i = 1; i <= N; ) {
                long q = N / i;
                long j = N / q;

                ans += q * (j - i + 1);
                i = j + 1;
            }

            System.out.println(ans - N);
        }

	}
}
