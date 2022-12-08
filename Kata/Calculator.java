package Kata;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Calculator {
	public static void main(String[] args) throws Exception {
		System.out.println(Add("-2"));
	}
	public static int Add(String s) throws Exception
	{
	    int ans=0;
	    int tmp=0;
		if (s.length()==0) 
			return 0;
		
		else if (s.indexOf('-') != -1)
			throw new Exception("negatives not allowed: -" +(s.charAt(s.indexOf('-')+1) - '0'));
		
		else {
			
			Pattern p = Pattern.compile("\\d+");
		    Matcher m = p.matcher(s);
		    
		    while(m.find()) {
		    	
		    	tmp=Integer.parseInt(m.group());
		    	if (tmp<=1000) 
		    		ans+=tmp;
		    	
		    }
		}
	    return ans;
	}
}