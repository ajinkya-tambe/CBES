package util;

import java.util.*;

public class Util
{
	public static String sortString(String str)
	{
		char ch[] = str.toCharArray();
		Arrays.sort(ch);
		return new String(ch);
	}
	
	/*public static void main(String arg[])
	{
		System.out.print(sortString("5,3,4").replace("," , ""));
	}*/
}