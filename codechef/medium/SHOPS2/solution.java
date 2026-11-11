import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int d = sc.nextInt();
		    
		   int[] a = new int[n];
		   int[] b=new int[n];
		   int suma=0;
		   int sumb=0;
		   int sumboth=0;
		   for(int i=0;i<n;i++)
		   {
		       a[i]=sc.nextInt();
		       suma+=a[i];
		   }
		   for(int i=0;i<n;i++)
		   {
		       b[i]=sc.nextInt();
		       sumb+=b[i];
		       sumboth+=Math.min(a[i],b[i]);
		   }
		   int cost1=d+suma;
		   int cost2=d+sumb;
		   int cost3=2*d+sumboth;
		   System.out.println(Math.min(cost1,Math.min(cost2,cost3)));
		}

	}
}
