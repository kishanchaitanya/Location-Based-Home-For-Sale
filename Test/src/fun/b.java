package fun;
import java.util.StringTokenizer;

import fun.a;

class ape{
	String ape;
	
	public ape()
	{
		System.out.println("In ape");
	}
	
	public void print()
	{
		System.out.println("IN ape");
	}
}

class bird extends ape {
	String bird;
	
	
	public bird()
	{
		System.out.println("IN bird");
	}
	public void print()
	{	
		System.out.println("In bird");
	}
}
public class b {

	public static void main(String[] args) {
	
		try{
			
			 long ard=-4;
			 String ref="1000 1000";
			 StringTokenizer r=new StringTokenizer(ref);
			 r.countTokens()
			 
			System.out.println(Math.abs(ard));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}
