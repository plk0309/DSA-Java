import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
		    int n=sc.nextInt();
		    String s=sc.next();
		    int count=0;
		    for(int i=0;i<n;i++)
		    {
		        int a=s.charAt(i)-'0';
		        int b=s.charAt((i+1)%n)-'0';
		        int num=a*10+b;
		        if(num%4==0)
		        {
		            count++;
		        }
		    }
		    System.out.println(count);
		}

	}
}
