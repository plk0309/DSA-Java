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
