import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int k=1;k<=t;k++){
		    int n=sc.nextInt();
		    int [] a=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		    }
		    int m=0;
		    for(int i=0;i<n;i++){
		        int o=0;
		        for(int j=i;j<n;j++){
		            if(a[j]%2!=0){
		                o++;
		            }
		            if(o%2==0){
		                m=Math.max(m,j-i+1);
		                
		            }
		        }
		    }
		    System.out.println(m);
		}

	}
}
