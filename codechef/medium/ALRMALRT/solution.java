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
		    long x=sc.nextLong();
		    long y=sc.nextLong();
		    long d=sc.nextLong();
		    long lcm=(x*y)/gcd(x,y);
		    long ans=lcm;
		    for(long time=x;time<=lcm;time+=x){
		        if(time>=y && time%y<=d){
		            ans=Math.min(ans,time);
		            break;
		        }
		    }
		    for(long time=y;time<=lcm;time+=y){
		        if(time>=x && time %x<=d){
		            ans=Math.min(ans,time);
		            break;
		        }
		    }
		    System.out.println(ans);
		}

	}
	static long gcd(long a , long b){
	    while(b!=0){
	        long temp=b;
	        b=a%b;
	        a=temp;
	    }
	    return a;
	}
}
