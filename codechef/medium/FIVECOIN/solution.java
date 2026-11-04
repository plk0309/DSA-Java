import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int c=0;
		if(n>=5){
		    c=1+(n-5);
		    
		}
		else{
		    c=n;
		}
		System.out.println(c);

	}
}
